package com.plush.lancet.weaver.internal.parser;

/**
 * Desc:
 *
 * @author lijt
 * Created on 2025/10/29
 * Email: lijt@eetrust.com
 */
public interface AcceptableAnnoParser extends AnnoParser {
    boolean accept(String desc);
}
