package org.web3soft.commons.security.xss;

import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;

/**
 * 基于{@link org.jsoup.Jsoup} 实现的XssFilter
 *
 * @author web3soft-team
 */
public class JsoupFilterPolicy implements FilterPolicy {
    /**
     * {@inheritDoc}
     */
    @Override
    public String filter(final String input) {
        return Jsoup.clean(input, Safelist.relaxed());
    }
}
