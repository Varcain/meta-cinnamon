SUMMARY = "Cinnamon Translations"
SECTION = "x11/libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b18004f797bf44bfaabd04b62fc006ed"
DEPENDS = ""

inherit cinnamon

SRC_URI[md5sum] = "e5c3f72fe42fb2206b1f411c9b407036"
SRC_URI[sha256sum] = "5f8eeb3c2d4af9ecd6a42cdf79cea6e6c92194aad6d37cf0a37724505da971a8"

do_compile () {
	cd ${S}
	make
}

do_install() {

}

PACKAGES =+ "cinnamon-translations"
