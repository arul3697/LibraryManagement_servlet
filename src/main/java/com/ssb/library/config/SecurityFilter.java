package main.java.com.ssb.library.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityFilter
 */

public class SecurityFilter implements Filter {
	private static final List<Pattern> excludePattern = new ArrayList<>();
	static {

		excludePattern.add(Pattern.compile("/library/login"));
		excludePattern.add(Pattern.compile("/library/register"));
		excludePattern.add(Pattern.compile("/library/reset"));
		excludePattern.add(Pattern.compile("/library/assets.*"));
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		System.out.println("filter" + request.getRequestURI());
		if (isExcludedUrl(request)) {
			chain.doFilter(request, response);
			return;
		}
		if ((session == null || (session != null && session.getAttribute("userdetails") == null))
				&& !"/library/login.jsp".equals(request.getRequestURI()) && !"/library/register.jsp".equals(request.getRequestURI()) && !"/library/resetPassword.jsp".equals(request.getRequestURI())) {
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}

		else {
			chain.doFilter(request, response);
		}
	}

	private boolean isExcludedUrl(HttpServletRequest httpRequest) {
		String reqURI = httpRequest.getRequestURI();
		return excludePattern.stream().anyMatch(pattern -> pattern.matcher(reqURI).matches());
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
