package com.haishangxian.security.distributed.order.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.haishangxian.security.distributed.order.model.TbUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yudongjie
 * @CreateDate: 2019-12-26 16:10
 */
@Component
public class TokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String token = httpServletRequest.getHeader("json-token");
        if(token!=null){

            JSONObject jsonObject = JSON.parseObject(token);

            //存user对象
            String principal = jsonObject.getString("principal");
            TbUser tbUser = JSONObject.parseObject(principal,TbUser.class);

            JSONArray jsonArray = jsonObject.getJSONArray("authorities");
            String[] strings = jsonArray.toArray(new String[jsonArray.size()]);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(tbUser,null, AuthorityUtils.createAuthorityList(strings));
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
