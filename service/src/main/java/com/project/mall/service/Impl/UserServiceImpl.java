package com.project.mall.service.Impl;

import com.project.mall.dao.UsersMapper;
import com.project.mall.entity.Users;
import com.project.mall.service.UserService;
import com.project.mall.utils.Base64Utils;
import com.project.mall.utils.MD5Utils;
import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author ydc
 * @create 2022-07-29 4:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UsersMapper usersMapper;


    @Transactional
    public ResultVo userRegister(String name, String pwd) {
        synchronized (this) {
            //1.根据用户查询，这个用户是否已经被注册
            Example example = new Example(Users.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("username", name);
            List<Users> users = usersMapper.selectByExample(example);
            //2.如果没有被注册则进行保存操作
            if (users.size() == 0) {
                String md5Pwd = MD5Utils.md5(pwd);
                Users user = new Users();
                user.setUsername(name);
                user.setPassword(md5Pwd);
                user.setUserImg("img/default.jpg");
                user.setUserRegtime(new Date());
                user.setUserModtime(new Date());
                int i = usersMapper.insertUseGeneratedKeys(user);//主键回旋，附带id一起返回
                if (i > 0) {
                    return new ResultVo(ResultStatus.OK, "注册成功1", user);
                } else {
                    return new ResultVo(ResultStatus.NO, "注册失败2", null);
                }
            } else {
                return new ResultVo(ResultStatus.NO, "注册失败3", null);
            }
        }
    }

    @Override
    public ResultVo checkLogin(String name, String pwd) {
        //根据条件查询用户
        Example example = new Example(Users.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", name);
        List<Users> users = usersMapper.selectByExample(example);

        if (users.size() == 0) {
            return new ResultVo(ResultStatus.NO, "登录失败，用户名不存在", null);
        } else {
            String md5Pwd = MD5Utils.md5(pwd);
            if (md5Pwd.equals(users.get(0).getPassword())) {
                JwtBuilder builder = Jwts.builder();
                HashMap<String, Object> map = new HashMap<>();         //JWT生成token

                String token = builder.setSubject(name)                //设置token携带的数据
                        .setIssuedAt(new Date())                       //设置token生成时间
                        .setId(users.get(0).getUserId() + "")          //设置用户id为tokenid
                        .setClaims(map)                                //存放用户角色权限信息
                        .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))//设置过期时间
                        .signWith(SignatureAlgorithm.HS256, "123456")//设置加密方式和加密密码
                        .compact();//返回token
//String token = Base64Utils.encode(name + 123456);
                return new ResultVo(ResultStatus.OK, token, users.get(0));
            } else {
                return new ResultVo(ResultStatus.NO, "登录失败", null);
            }
        }
    }
}

