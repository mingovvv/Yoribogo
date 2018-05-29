package com.yoribogo.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.yoribogo.dao.MemberDao;
import com.yoribogo.entity.Member;

public class YoribogoPre implements ViewPreparer{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public void execute(Request  tilesRequest
										, AttributeContext attributeContext) {
		// ********** 로그인 된 상태에서 만 실행되는 코드를 작성할 경우 ******************
		// 현재 로그인 한 사용자의 인증객체를 얻는다.
		final Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				// 인증된 사용자의 Course 정보 얻는 방법
			    if (!(auth instanceof AnonymousAuthenticationToken)) {
					
					// 인증객체를 통해서 인증에 사용된 id를 얻는다.
			        final UserDetails userDetails = (UserDetails) auth.getPrincipal();
			        final String username = userDetails.getUsername();
			        
			        // 이제 인증 id를 이용해서 Course 객체를 얻어온다.
			        Member member = memberDao.get(username);
			        
			        // 위의 course 객체를 model 저장소에 담는다.
			        Map<String, Object> model = tilesRequest.getContext("request");
			        model.put("member", member);
			        
			        // 혹시...만약에 서블릿 Request 객체를 얻고 싶을 때는 다음과 같은 코드를 작성해서 얻는다.
			        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
						        
			    }
		
	}

}
