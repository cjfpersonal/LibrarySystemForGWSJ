package com.gwsj.j2ee.Dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.management.Query;

import org.aspectj.weaver.reflect.ReflectionBasedResolvedMemberImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gwsj.j2ee.pojo.Student_Info;
import com.gwsj.j2ee.vo.UserVo;

@Repository
public class BaseDao<T, PK extends Serializable>{
	
	protected Class<T> entityClass;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	private Class<T> getEntityClass() {
		// TODO Auto-generated method stub
		if(entityClass==null)
		{
			 Type t = getClass().getGenericSuperclass();
		        if(t instanceof ParameterizedType){
		            Type[] p = ((ParameterizedType)t).getActualTypeArguments();
		            this.entityClass = (Class<T>)p[0];
		        }
		
		}
		return this.entityClass;
	}
	
	public Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	/*
	 * 通过前端传过来的model，用户名信息进行查询
	 * @param UserVo
	 * @return boolean
	 * 
	 */
	public Boolean findbyUserVo(UserVo userVo)
	{
		
		boolean flag=false;
		String hql="";
		if(userVo.getStatue().equals("0")){
			hql="from Student_Info where student_id=? and student_password=?";
		}
		else if(userVo.getStatue().equals("1")){
			hql="from Aministrator_Info where ausername=? and apassword=?";
		}
		
		org.hibernate.Query query=getCurrentSession().createQuery(hql);
		
		try{
			
			if(userVo.getStatue().equals("0")){
				Integer number=Integer.valueOf(userVo.getUserid());
				query.setParameter(0, number);
			}
			else if(userVo.getStatue().equals("1")){
				query.setParameter(0, userVo.getUserid().toString());
			}
			
		}
		catch(Exception e)
		{
			flag=false;
			return false;
		}
		
		
		query.setParameter(1, userVo.getPassword());
		
		List<Student_Info> student_Infos=query.list();
		
		if(student_Infos.size()>0)
		{
			flag=true;
			return flag;
		}
		
	    return flag;
	}
	
	/*
	 * 保存对象到数据库
	 * 
	 */
	public Boolean save(T t)
	{
		Session session=getCurrentSession();
		Integer i=(Integer) session.save(t);
		session.flush();  //输出缓存区  这一句才是真正执行插入操作
		if(i>0)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * 在数据库中删除对象
	 * 
	 */
     public Boolean delete(T t)
     {
    	 
    	 return false;
     }
     /*
      * 
      * 通过id得到对象
      */
	public T get(int id)
	{
	    T t = (T) getCurrentSession().get(getEntityClass(), id);
		return t;
	}

	

}
