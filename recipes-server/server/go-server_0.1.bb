SUMMARY = "A simple Go server"
DESCRIPTION = "Recipe created by bitbake-layers"
LICENSE = "MIT"

inherit go

FILESEXTRAPATHS_prepend := "${THISDIR}/go_src:"
export GOARCH="amd64"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

S = "${WORKDIR}"
SRC_URI += " \
  file://server.go \
"

do_compile() {
  ${GO} build -o ${S}/go_server ${S}/server.go
}

do_install() {
  install -d ${D}${bindir}
  install -m 0755 ${S}/go_server ${D}${bindir}
}
