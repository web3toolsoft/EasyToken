package org.web3soft.commons.security.xss;

import org.owasp.encoder.Encode;

/**
 * 基于@see org.owasp.encoder.Encode 实现的XssFilter
 *
 * @author web3soft-team
 */
public class OwaspFilterPolicy implements FilterPolicy {
    /**
     * {@inheritDoc}
     */
    @Override
    public String filter(final String input) {
        return Encode.forHtmlContent(input);
    }
}
