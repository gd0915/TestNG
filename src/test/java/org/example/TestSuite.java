package org.example;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.CustomAttribute;
import org.testng.annotations.Test;

import java.lang.annotation.Annotation;

public class TestSuite implements Test {
    public TestSuite(Class<AppTest> appTestClass) {
    }

    @Override
    public String[] groups() {
        return new String[0];
    }

    @Override
    public boolean enabled() {
        return false;
    }

    @Override
    public String[] dependsOnGroups() {
        return new String[0];
    }

    @Override
    public String[] dependsOnMethods() {
        return new String[0];
    }

    @Override
    public long timeOut() {
        return 0;
    }

    @Override
    public long invocationTimeOut() {
        return 0;
    }

    @Override
    public int invocationCount() {
        return 0;
    }

    @Override
    public int threadPoolSize() {
        return 0;
    }

    @Override
    public int successPercentage() {
        return 0;
    }

    @Override
    public String dataProvider() {
        return null;
    }

    @Override
    public Class<?> dataProviderClass() {
        return null;
    }

    @Override
    public boolean alwaysRun() {
        return false;
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public Class[] expectedExceptions() {
        return new Class[0];
    }

    @Override
    public String expectedExceptionsMessageRegExp() {
        return null;
    }

    @Override
    public String suiteName() {
        return null;
    }

    @Override
    public String testName() {
        return null;
    }

    @Override
    public boolean singleThreaded() {
        return false;
    }

    @Override
    public Class<? extends IRetryAnalyzer> retryAnalyzer() {
        return null;
    }

    @Override
    public boolean skipFailedInvocations() {
        return false;
    }

    @Override
    public boolean ignoreMissingDependencies() {
        return false;
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public CustomAttribute[] attributes() {
        return new CustomAttribute[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
