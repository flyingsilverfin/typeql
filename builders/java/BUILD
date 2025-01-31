#This Source Code Form is subject to the terms of the Mozilla Public
# License, v. 2.0. If a copy of the MPL was not distributed with this
# file, You can obtain one at https://mozilla.org/MPL/2.0/.


package(default_visibility = ["//visibility:public"])

load("@typedb_bazel_distribution//github:rules.bzl", "deploy_github")
load("@typedb_bazel_distribution//maven:rules.bzl", "assemble_maven", "deploy_maven")
load("@typedb_dependencies//distribution:deployment.bzl", "deployment")
load("@typedb_dependencies//tool/checkstyle:rules.bzl", "checkstyle_test")
load("@typedb_dependencies//tool/release/deps:rules.bzl", "release_validate_deps")
load("//:deployment.bzl", github_deployment = "deployment")

java_library(
    name = "typeql-builders",
    srcs = ["TypeQLBuilder.java"],
    tags = ["maven_coordinates=com.typeql:typeql-lang:{pom_version}"],
    deps = [ ],
)

#
#assemble_maven(
#    name = "assemble-maven",
#    target = ":typeql-lang",
#    workspace_refs = "@typeql_workspace_refs//:refs.json",
#)
#
#deploy_maven(
#    name = "deploy-maven",
#    release = deployment["maven"]["release"]["upload"],
#    snapshot = deployment["maven"]["snapshot"]["upload"],
#    target = ":assemble-maven",
#)
#
#deploy_github(
#    name = "deploy-github",
#    draft = False,
#    organisation = github_deployment["github.organisation"],
#    release_description = "//:RELEASE_NOTES_LATEST.md",
#    repository = github_deployment["github.repository"],
#    title = "TypeQL language library for Java",
#    title_append_version = True,
#)
#
checkstyle_test(
    name = "checkstyle",
    include = glob([
        "*",
        "docs/*",
    ]),
    exclude = [
        "docs/package-structure.dot",
        "docs/package-structure.png",
        "README.md",
    ],
    license_type = "mpl-header",
)

checkstyle_test(
    name = "checkstyle-license",
    include = ["//:LICENSE"],
    license_type = "mpl-fulltext",
)
