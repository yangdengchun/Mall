package com.project.mall.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.mall.vo.ResultStatus;
import com.project.mall.vo.ResultVo;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ydc
 * @create 2022-08-07 9:15
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if ("OPTION".equalsIgnoreCase(method)){
            return true;
        }
        String token = request.getParameter("token");
        ResultVo vo = new ResultVo(ResultStatus.NO, "请先登录", null);
        if (token == null){
            doResponse(response,vo);
        }else {
            try {
                JwtParser parser = Jwts.parser();
                parser.setSigningKey("123456");
                Jws<Claims> claimsJws = parser.parseClaimsJws(token);
                return true;

            }catch (ExpiredJwtException e){
                ResultVo resultVo = new ResultVo(ResultStatus.NO, "登录过期,请重新登录", null);
                doResponse(response,resultVo);
            }catch (UnsupportedJwtException e){
                ResultVo resultVo = new ResultVo(ResultStatus.NO, "Token不合法", null);
                doResponse(response,resultVo);
            }catch (Exception e){
                ResultVo resultVo = new ResultVo(ResultStatus.NO, "请先登录", null);
                doResponse(response,resultVo);
            }
        }
        return false;
    }

    private void doResponse(HttpServletResponse response,ResultVo vo) throws IOException {
        response.setContentType("application/json");//提示返回json
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();//获取流
        String s = new ObjectMapper().writeValueAsString(vo);//将数据序列化为json格式
        out.print(s);
        out.flush();
        out.close();

    }
}
