package org.tubetrue01.testprovider.aspect;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2020/2/10
 * Time : 8:20 下午
 * Description :
 */
@Component
public class TransactionAspect {
    // Point
    private static final String AOP_POINTCUT_EXPRESSION = "execution(* org.tubetrue01.testprovider.service.*Service.*(..))";

    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {
        var source = new NameMatchTransactionAttributeSource();

        /* Read-only transaction, no update operation */
        var readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS);

        /* The current transaction exists when the current transaction exists, and a new transaction is created when there is no current transaction */
        var requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        var txMap = new HashMap<String, TransactionAttribute>();

        /* Configuring the prefix of the transaction method */
        txMap.put("add*", requiredTx);
        txMap.put("save*", requiredTx);
        txMap.put("insert*", requiredTx);
        txMap.put("create*", requiredTx);
        txMap.put("batch*", requiredTx);
        txMap.put("update*", requiredTx);
        txMap.put("modify*", requiredTx);
        txMap.put("delete*", requiredTx);
        txMap.put("remove*", requiredTx);
        /* Configuring the prefix of the read-only transaction method */
        txMap.put("get*", readOnlyTx);
        txMap.put("query*", readOnlyTx);
        txMap.put("find*", readOnlyTx);
        txMap.put("select*", readOnlyTx);
        /* The rest of the methods add transactions */
        txMap.put("*", requiredTx);
        source.setNameMap(txMap);

        return new TransactionInterceptor(transactionManager, source);
    }

    /**
     * Registration transaction
     */
    @Bean
    public Advisor txAdviceAdvisor(TransactionInterceptor txAdvice) {
        var pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice);
    }
}
