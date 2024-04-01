package com.umbrella.justauth.support.extend;

import me.zhyd.oauth.config.AuthSource;
import me.zhyd.oauth.request.AuthDefaultRequest;

public enum ExtendSource implements AuthSource {
    HUIONE {
        /**
         * 授权的API
         * @return
         */
        @Override
        public String authorize() {
            return "https://authorize";
        }

        /**
         * 获取accessToken的API
         * @return
         */
        @Override
        public String accessToken() {
            return null;
        }

        /**
         * 获取用户信息的API
         * @return
         */
        @Override
        public String userInfo() {
            return null;
        }


        /**
         * 取消授权的API
         * @return
         */
        @Override
        public String revoke() {
            return super.revoke();
        }


        /**
         * 刷新授权的API
         * @return
         */
        @Override
        public String refresh() {
            return super.refresh();
        }

        @Override
        public Class<? extends AuthDefaultRequest> getTargetClass() {
            return null;
        }

    };


}
