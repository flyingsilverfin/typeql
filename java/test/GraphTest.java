/*
 * Copyright (C) 2020 Grakn Labs
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package graql.lang.test;

import graql.lang.Graql;
import graql.lang.pattern.variable.BoundVariable;
import graql.lang.pattern.variable.Reference;
import graql.lang.pattern.variable.ThingVariable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GraphTest {
    @Test
    public void test() {
        List<ThingVariable<?>> boundedRange = Arrays.asList(Graql.var("x").gt(0L), Graql.var("x").lt(10L));
        Map<Reference, BoundVariable<?>> graph = BoundVariable.asGraph(boundedRange);
        System.out.println(graph);
    }
}
