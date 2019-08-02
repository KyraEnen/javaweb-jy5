package com.itdr.service;



import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

public class UserService {

    //1.获取用户列表
    private UserDao ud = new UserDao();   //注入灵魂

    public ResponseCode<Users> selectAll(String pageSize, String pageNum) {
        //做参数非空判断
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageNum.equals("")) {
            pageNum = "1";
        }
        List<Users> li = ud.selectAll(pageSize, pageNum);

        //如果集合元素是空呢

        //把数据集合放进来
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);

        return rs;

    }

    //2.用户登录
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs = new ResponseCode();
        //判断用户是否为空
        if (username == null || username.equals("") || password == null || password.equals("")) {
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        //查找是否有这样一个用户
        Users u = ud.selectOne(username, password);

        //如果用户不存在
        if (u == null) {
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }

        //用户权限
        if (u.getType()!=1) {
            rs.setStatus(2);
            rs.setMag("没有操作权限！");
            return rs;
        }

        //以上情况都不是返回用户登录后的状态码，信息
        rs.setStatus(0);
        rs.setData(u);
        return rs;
    }

    //3.禁用用户
    public ResponseCode selectOne(String uids) {
        ResponseCode rs = new ResponseCode();
        //判断用户是否为空
        if (uids== null ||uids.equals("")) {
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }

        //字符串转数值
        Integer uid=null;
        try {
           uid = Integer.parseInt(uids);
        }catch(Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }
        //查找是否有这样一个用户
        Users u = ud.selectOne(uid);


        //如果用户不存在
        if (u == null) {
            rs.setStatus(Const.USER_NO_CODE);
            rs.setMag(Const.USER_NO_MSG);
            return rs;
        }

        //用户禁用情况
        if (u.getStats()==1) {
            rs.setStatus(Const.USER_DIISABLE_CODE);
            rs.setMag(Const.USER_DIISABLE_MSG);
            return rs;
        }

        //禁用用户
        int row=ud.updateByUid(uid);

        //如果影响的行数是0 说明禁用失败
        if (row<=0){
            rs.setStatus(106);
            rs.setMag("用户禁用更新失败");
            return rs;
        }

        rs.setStatus(0);    //这里为什么是0  ？？？
        rs.setData(row);
        return rs;
    }
}
