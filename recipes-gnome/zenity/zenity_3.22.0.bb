SUMMARY = "Display dialog boxes from the commandline and shell scripts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=3bf50002aefd002f49e7bb854063f7e7"
DEPENDS = "gtk+3 libnotify"
RDEPENDS_zenity = "perl"

inherit gnomebase gettext pkgconfig

SRC_URI += "file://remove_yelp_variable.patch"

SRC_URI[archive.md5sum] = "eaf4cbaac3a356817b837668b5a45a97"
SRC_URI[archive.sha256sum] = "1ecdfa1071d383b373b8135954b3ec38d402d671dcd528e69d144aff36a0e466"

do_install_append_class-target() {
        install -d ${D}${bindir}/
        install ${B}/src/zenity ${D}${bindir}/
}

SYSROOT_DIRS_append_class-target = " ${bindir}"
