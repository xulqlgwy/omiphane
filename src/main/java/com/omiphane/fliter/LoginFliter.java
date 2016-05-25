package com.omiphane.fliter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by Administrator on 2015/3/12.
 */
public class LoginFliter extends OncePerRequestFilter {
    public static  final String SESSION_KEY = "session_key";
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println(httpServletRequest.getRequestURI());
        filterChain.doFilter(httpServletRequest,httpServletResponse);
        return;
        // 不过滤的uri
//        String[] notFilter =
//                new String[] {"/images", "/js", "/css", "/login/tologin", "/login/mainframe", "/user/exist",
//                        "/user/checkPassword", "/signcode"};
//
//        // 请求的uri
//        String uri = httpServletRequest.getRequestURI();
//        // 是否过滤
//        boolean doFilter = true;
//        for (String s : notFilter)
//        {
//            if (uri.indexOf(s) != -1)
//            {
//                // 如果uri中包含不过滤的uri，则不进行过滤
//                doFilter = false;
//                break;
//            }
//        }
//
//        if (doFilter)
//        {
//            // 执行过滤
//            // 从session中获取登录者实体
//            Object obj = httpServletRequest.getSession().getAttribute(SESSION_KEY);
//            if (null == obj)
//            {
//                boolean isAjaxRequest = isAjaxRequest(httpServletRequest);
//                if (isAjaxRequest)
//                {
//                    httpServletResponse.setCharacterEncoding("UTF-8");
//                    httpServletResponse.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
//                    httpServletResponse.sendRedirect("/area/index");
//                    return ;
//                }else {
//                    httpServletRequest.setAttribute(SESSION_KEY,"xulq");
//                    filterChain.doFilter(httpServletRequest, httpServletResponse);
//                }
//                return;
//            }
//            else
//            {
//                // 如果session中存在登录者实体，则继续
//                filterChain.doFilter(httpServletRequest, httpServletResponse);
//            }
//        }
//        else
//        {
//            // 如果不执行过滤，则继续
//            filterChain.doFilter(httpServletRequest, httpServletResponse);
//        }
    }

    /** 判断是否为Ajax请求
     * <功能详细描述>
     * @param request
     * @return 是true, 否false
     * @see [类、类#方法、类#成员]
     */
    public static boolean isAjaxRequest(HttpServletRequest request)
    {
        String header = request.getHeader("X-Requested-With");
        if (header != null && "XMLHttpRequest".equals(header))
            return true;
        else
            return false;
    }
}
