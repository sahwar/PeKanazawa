package jp.co.pekanazawa.component.login;

import java.util.Map;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.ConstUtil;
import utility.UrlUtil;

@Component
@Aspect
public class LoginCheckInterceptor {

    @Autowired
    protected LoginDto loginDto;

    @Resource(name = "noRedirectUrlAndMethodMap")
    protected Map<String, String> noRedirectUrlAndMethodMap;

    protected static final String loginPageUrl = "/login/index";

    @Around("within(jp.co.pekanazawa.auth.web..*Controller)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        String controllerName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // FIXME メソッドアノテーション判断にするか。。
        if (!this.isExclusion(this.noRedirectUrlAndMethodMap, controllerName, methodName)) {
            if (!this.loginDto.isLogin()) {
                // TODO 参照先（パッケージ構成）がおかしい。DIするか、、、どうするか。。。
                return UrlUtil.redirectTo(loginPageUrl);
            }
        }
        return joinPoint.proceed();
    }

    private boolean isExclusion(Map<String, String> exclusion, String controllerName, String methodName) {
        if (exclusion.containsKey(controllerName)) {
            String targetMethods = exclusion.get(controllerName);
            String[] splits = targetMethods.split(ConstUtil.COMMNA);
            for (String row : splits) {
                if (row.equals(methodName)) {
                    return true;
                }
            }
        }
        return false;
    }

}
