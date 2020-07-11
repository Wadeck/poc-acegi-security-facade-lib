/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.acegisecurity;
/* Used by:
active-directory
assembla-auth
azure-ad
backlog
bitbucket-oauth
cas-plugin
coding-webhook
crowd2
delivery-pipeline-plugin
github-oauth
gitlab-oauth
google-login
keycloak
ldap
mock-security-realm
oic-auth
openid
openshift-login
pam-auth
pwauth
reverse-proxy-auth-plugin
role-strategy
saml
script-realm
tuleap-oauth
wso2id-oauth
wwpass-plugin
 */

/**
 * Thrown if an authentication request is rejected because the credentials are invalid. For this exception to be
 * thrown, it means the account is neither locked nor disabled.
 *
 * @author Ben Alex
 * @version $Id: BadCredentialsException.java 2654 2008-02-18 20:44:09Z luke_t $
 */
public class BadCredentialsException extends AuthenticationException {
    /**
     * Constructs a <code>BadCredentialsException</code> with the specified
     * message.
     *
     * @param msg the detail message
     */
    public BadCredentialsException(String msg) {
        super(msg);
    }

    public BadCredentialsException(String msg, Object extraInformation) {
        super(msg, extraInformation);
    }

    /**
     * Constructs a <code>BadCredentialsException</code> with the specified
     * message and root cause.
     *
     * @param msg the detail message
     * @param t   root cause
     */
    public BadCredentialsException(String msg, Throwable t) {
        super(msg, t);
    }
}
