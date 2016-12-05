SUMMARY = "Cinnamon Session"
SECTION = "x11/libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "virtual/libx11 libcanberra"

inherit cinnamon autotools gettext gobject-introspection update-alternatives

SRC_URI += "file://ignore_warnings.patch"

SRC_URI[md5sum] = "46fe89aa885a4460c0fafc7a7cc7a973"
SRC_URI[sha256sum] = "d8935747bc8aa70518e70a7d338eaf9109b5307d8a44d49dc57e0f15d69e9c89"

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/cinnamon-session"
ALTERNATIVE_PRIORITY_${PN} = "100"

PACKAGES =+ "libcinnamon-session"
FILES_libcinnamon-session = "${datadir}/glib-2.0/* ${datadir}/icons/*"
