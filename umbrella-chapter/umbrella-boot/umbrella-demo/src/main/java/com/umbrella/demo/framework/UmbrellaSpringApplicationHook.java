package com.umbrella.demo.framework;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationHook;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.time.Duration;

/**
 * 低级钩子，可以用来将SpringApplicationRunListener附加到spring应用程序，
 * 以便观察或修改其行为。挂钩在每个线程的基础上进行管理，在多个应用程序并行执行时提供隔离。
 */
public class UmbrellaSpringApplicationHook implements SpringApplicationHook {
    /**
     * Return the {@link SpringApplicationRunListener} that should be hooked into the
     * given {@link SpringApplication}.
     *
     * @param springApplication the source {@link SpringApplication} instance
     * @return the {@link SpringApplicationRunListener} to attach
     */
    @Override
    public SpringApplicationRunListener getRunListener(SpringApplication springApplication) {
        return new SpringApplicationRunListener() {
            /**
             * Called immediately when the run method has first started. Can be used for very
             * early initialization.
             *
             * @param bootstrapContext the bootstrap context
             */
            @Override
            public void starting(ConfigurableBootstrapContext bootstrapContext) {
                SpringApplicationRunListener.super.starting(bootstrapContext);
                System.out.println("starting::::::::::::");
            }

            /**
             * Called once the environment has been prepared, but before the
             * {@link ApplicationContext} has been created.
             *
             * @param bootstrapContext the bootstrap context
             * @param environment      the environment
             */
            @Override
            public void environmentPrepared(ConfigurableBootstrapContext bootstrapContext, ConfigurableEnvironment environment) {
                SpringApplicationRunListener.super.environmentPrepared(bootstrapContext, environment);
                System.out.println("environmentPrepared::::::::::::");
            }

            /**
             * Called once the {@link ApplicationContext} has been created and prepared, but
             * before sources have been loaded.
             *
             * @param context the application context
             */
            @Override
            public void contextPrepared(ConfigurableApplicationContext context) {
                SpringApplicationRunListener.super.contextPrepared(context);
                System.out.println("contextPrepared::::::::::::");
            }

            /**
             * Called once the application context has been loaded but before it has been
             * refreshed.
             *
             * @param context the application context
             */
            @Override
            public void contextLoaded(ConfigurableApplicationContext context) {
                SpringApplicationRunListener.super.contextLoaded(context);
                System.out.println("contextLoaded::::::::::::");
            }

            /**
             * The context has been refreshed and the application has started but
             * {@link CommandLineRunner CommandLineRunners} and {@link ApplicationRunner
             * ApplicationRunners} have not been called.
             *
             * @param context   the application context.
             * @param timeTaken the time taken to start the application or {@code null} if unknown
             * @since 2.6.0
             */
            @Override
            public void started(ConfigurableApplicationContext context, Duration timeTaken) {
                SpringApplicationRunListener.super.started(context, timeTaken);
                System.out.println("started::::::::::::");
            }

            /**
             * Called immediately before the run method finishes, when the application context has
             * been refreshed and all {@link CommandLineRunner CommandLineRunners} and
             * {@link ApplicationRunner ApplicationRunners} have been called.
             *
             * @param context   the application context.
             * @param timeTaken the time taken for the application to be ready or {@code null} if
             *                  unknown
             * @since 2.6.0
             */
            @Override
            public void ready(ConfigurableApplicationContext context, Duration timeTaken) {
                SpringApplicationRunListener.super.ready(context, timeTaken);
                System.out.println("ready::::::::::::");
            }

            /**
             * Called when a failure occurs when running the application.
             *
             * @param context   the application context or {@code null} if a failure occurred before
             *                  the context was created
             * @param exception the failure
             * @since 2.0.0
             */
            @Override
            public void failed(ConfigurableApplicationContext context, Throwable exception) {
                SpringApplicationRunListener.super.failed(context, exception);
                System.out.println("failed::::::::::::");
            }
        };
    }
}
