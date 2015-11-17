package jp.co.pekanazawa.component.login;

import jp.co.pekanazawa.auth.web.FormConst;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.UrlUtil;

@Component
@Aspect
public class LoginCheckInterceptor {

    @Autowired
    protected LoginDto loginDto;

    @Around("within(jp.co.pekanazawa.auth.web..*Controller)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println(joinPoint);
        if (!this.loginDto.isLogin()) {
            // TODO 参照先（パッケージ構成）がおかしい。DIするか、、、どうするか。。。
            return UrlUtil.redirectTo(FormConst.LOGIN);
        }
        return joinPoint.proceed();
    }

}
