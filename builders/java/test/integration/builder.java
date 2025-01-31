/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.typeql.test;

import com.typeql.lang.TypeQLBuilder;
import org.junit.Test;

import static com.typeql.lang.TypeQLBuilder.Initializer.match;
import static com.typeql.lang.TypeQLBuilder.Initializer.player;
import static com.typeql.lang.TypeQLBuilder.Initializer.relation;
import static com.typeql.lang.TypeQLBuilder.Initializer.var;

public class Builder {

    @Test
    public void test() {
        // match
        //   $user isa user, has username "user_0";
        // insert $user has status "VIP";
        // match
        //   friendship (friend: $user, friend: $friend);
        //   friendship (friend: $friend, friend: $friend-of-friend);
        //   $friend-of-friend has status "VIP";
        // reduce $VIP-friend-count = count groupby $friend;
        // match $VIP-friend-count > 5;
        // insert $friend has status "VIP";

        TypeQLBuilder builder =
            match(
                var("user").isa("user").has("username", "user_0")
            ).insert(
                relation("friendship", player("friend", var("user")), player("friend", var("friend"))),
                relation("friendship", player("friend", var("friend")), player("friend", var("friend-of-friend"))),
                var("friend-of-friend").has("status", "VIP")
            ).reduce(
                var("VIP-friend-count").assign("count").groupby(var("friend"))
            ).match(
                var("VIP-friend-count").gt(5)
            ).insert(
                var("friend").has("status", "VIP")
            );

        System.out.println(builder.toString());
    }
}
