/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.typeql.lang;

public class TypeQLBuilder {
    public String query;

    TypeQLBuilder(String init) {
        this.query = init;
    }

    public TypeQLBuilder match(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("match\n").add_all(";\n", statements);
    }

    public TypeQLBuilder define(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("define\n").add_all(";\n", statements);
    }

    public TypeQLBuilder undefine(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("undefine\n").add_all(";\n", statements);
    }

    public TypeQLBuilder redefine(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("redefine\n").add_all(";\n", statements);
    }

    public TypeQLBuilder insert(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("insert\n").add_all(";\n", statements);
    }

    public TypeQLBuilder put(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("put\n").add_all(";\n", statements);
    }

    public TypeQLBuilder update(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("update\n").add_all(";\n", statements);
    }

    public TypeQLBuilder delete(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("delete\n").add_all(";\n", statements);
    }

    public TypeQLBuilder select(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("select\n").add_all(";\n", statements);
    }

    public TypeQLBuilder sort(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("sort\n").add_all(";\n", statements);
    }

    public TypeQLBuilder offset(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("offset\n").add_all(";\n", statements);
    }

    public TypeQLBuilder limit(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("limit\n").add_all(";\n", statements);
    }

    public TypeQLBuilder require(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("require\n").add_all(";\n", statements);
    }

    public TypeQLBuilder reduce(com.typeql.lang.TypeQLBuilder... statements) {
        return this.add("reduce\n").add_all(";\n", statements);
    }

    public TypeQLBuilder isa(TypeQLBuilder type) {
        return this.add(", isa ").add(type);
    }

    public TypeQLBuilder isa(String type) {
        return isa(new TypeQLBuilder(type));
    }

    public TypeQLBuilder has(TypeQLBuilder type, TypeQLBuilder value) {
        return this.add(", has ").add(type).add(" ").add(value);
    }

    public TypeQLBuilder has(String type, String value) {
        return this.has(new TypeQLBuilder(type), new TypeQLBuilder(value));
    }

    public TypeQLBuilder assign(String operator) {
        return this.add(" = ").add(operator);
    }

    public TypeQLBuilder groupby(TypeQLBuilder var) {
        return this.add(" groupby ").add(var);
    }

    public TypeQLBuilder gt(int value) {
        return this.add(" > ").add(String.valueOf(value));
    }

    public TypeQLBuilder add(String segment) {
        return new TypeQLBuilder(this.query + segment);
    }

    public TypeQLBuilder add(com.typeql.lang.TypeQLBuilder other) {
        return new TypeQLBuilder(this.query + other.query);
    }

    public TypeQLBuilder add_all(String joiner, TypeQLBuilder... elements) {
        if (elements.length > 0) {
            StringBuilder concatenated = new StringBuilder(this.query);
            for (com.typeql.lang.TypeQLBuilder element : elements) {
                concatenated.append(element.query).append(joiner);
            }
            return new TypeQLBuilder(concatenated.toString());
        } else {
            return this;
        }
    }

    public String toString() {
        return this.query;
    }

    public static class Initializer {

        public static TypeQLBuilder match(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").match(statements);
        }

        public static  TypeQLBuilder define(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").define(statements);
        }

        public static TypeQLBuilder undefine(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").undefine(statements);
        }

        public static TypeQLBuilder redefine(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").redefine(statements);
        }

        public static TypeQLBuilder insert(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").insert(statements);
        }

        public static TypeQLBuilder put(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").put(statements);
        }

        public static TypeQLBuilder update(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").update(statements);
        }

        public static TypeQLBuilder delete(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").delete(statements);
        }

        public static TypeQLBuilder select(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").select(statements);
        }

        public static TypeQLBuilder sort(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").sort(statements);
        }

        public static TypeQLBuilder offset(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").offset(statements);
        }

        public static TypeQLBuilder limit(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").limit(statements);
        }

        public static TypeQLBuilder require(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").require(statements);
        }

        public static TypeQLBuilder reduce(com.typeql.lang.TypeQLBuilder... statements) {
            return new TypeQLBuilder("").reduce(statements);
        }

        // ---

        public static TypeQLBuilder var(String name) {
            return new TypeQLBuilder("$" + name);
        }

        public static TypeQLBuilder player(TypeQLBuilder role, TypeQLBuilder var) {
            return new TypeQLBuilder(role + ": ").add(var);
        }

        public static TypeQLBuilder player(String role, TypeQLBuilder var) {
            return player(new TypeQLBuilder(role), var);
        }

        public static TypeQLBuilder relation(TypeQLBuilder type, TypeQLBuilder... players) {
            return type.add(" (").add_all(", ", players).add(" )");
        }

        public static TypeQLBuilder relation(String type, TypeQLBuilder... players) {
            return relation(new TypeQLBuilder(type), players);
        }
    }
}