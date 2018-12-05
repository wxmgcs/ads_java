package cn.diyai.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class UniqueEmailAddresses {

    //fixme
    public int numUniqueEmails(String[] emails) {

        Hashtable<String, Set<String>> hashMap = new Hashtable<>();
        for (String email : emails) {
            if (email.startsWith("@") || email.endsWith("@")) {
                continue;
            }
            Set<String> hashSetLocal = new HashSet<>();
            String local = email.split("@")[0];
            String domain = email.split("@")[1];
            local = local.replace(".", "");
            if (local.contains("+")) {
                String[] temp = local.split("\\+");
                String part1 = temp[0];
                String part2 = "";
                if (temp.length > 1) {
                    part2 = temp[1];
                }
                String part3 = "";
                if (part2.contains("+")) {
                    if (part2.split("\\+").length > 1) {
                        part3 = part2.split("\\+")[1];
                    }

                }
                local = part1 + part3;
            }
            if (local != null && !local.equals("")) {
                hashSetLocal.add(local);
            }
            hashMap.put(domain, hashSetLocal);
        }

        int res = 0;
        for (Set<String> set : hashMap.values()) {
            res += set.size();
        }

        return res;
    }

    @Test
    public void test() {

        Assert.assertEquals(2, numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"}));
    }
}
