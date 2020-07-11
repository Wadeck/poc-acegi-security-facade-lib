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
ibm-continuous-release
job-restrictions
keycloak
ldap
matrix-auth
mock-security-realm
oic-auth
openid
openshift-login
pam-auth
pwauth
redmine
reverse-proxy-auth-plugin
saml
script-realm
skype-notifier
tuleap-oauth
urbancode-velocity
url-auth-sso
wso2id-oauth
wwpass-plugin
 */

/**
 * Abstract superclass for all exceptions related an {@link Authentication} object being invalid for whatever
 * reason.
 *
 * @author Ben Alex
 * @version $Id: AuthenticationException.java 2654 2008-02-18 20:44:09Z luke_t $
 */
public abstract class AuthenticationException extends AcegiSecurityException {

    private Authentication authentication;
    private Object extraInformation;

    //~ Constructors ===================================================================================================

    /**
     * Constructs an <code>AuthenticationException</code> with the specified
     * message and root cause.
     *
     * @param msg the detail message
     * @param t   the root cause
     */
    public AuthenticationException(String msg, Throwable t) {
        super(msg, t);
    }

    /**
     * Constructs an <code>AuthenticationException</code> with the specified
     * message and no root cause.
     *
     * @param msg the detail message
     */
    public AuthenticationException(String msg) {
        super(msg);
    }

    public AuthenticationException(String msg, Object extraInformation) {
        super(msg);
        this.extraInformation = extraInformation;
    }

    //~ Methods ========================================================================================================

    /**
     * The authentication request which this exception corresponds to (may be <code>null</code>)
     */
    public Authentication getAuthentication() {
        return authentication;
    }

    void setAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }

    /**
     * Any additional information about the exception. Generally a <code>UserDetails</code> object.
     *
     * @return extra information or <code>null</code>
     */
    public Object getExtraInformation() {
        return extraInformation;
    }

    void clearExtraInformation() {
        this.extraInformation = null;
    }
}
