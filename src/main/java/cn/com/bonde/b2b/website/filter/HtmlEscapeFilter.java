package cn.com.bonde.b2b.website.filter;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HtmlEscapeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
                                                                                             ServletException {
        HttpServletRequest hreq = (HttpServletRequest) request;
        Map map = hreq.getParameterMap();
        Iterator itr = map.keySet().iterator();
        while (itr.hasNext()) {
            String key = itr.next().toString();
            String[] values = hreq.getParameterValues(key);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    values[i] = cleanXSS(values[i]);
                }
            }
            hreq.setAttribute(key, values);
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    private String cleanXSS(String value) {
        value = value.replaceAll("<", "& lt;")
                .replaceAll(">", "& gt;")
                .replaceAll("\\(", "& #40;")
                .replaceAll("\\)","&#41;")
                .replaceAll("'","& #39;")
                .replaceAll("eval\\((.*)\\)","")
                .replaceAll("[\\\"<a>\\\'][\\s]*javascript:(.*)[\\\"\\\'</a>]","\"\"")
                .replaceAll("script","");
        return value;
    }

}
