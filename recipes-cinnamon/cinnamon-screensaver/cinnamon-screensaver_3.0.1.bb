SUMMARY = "Cinnamon Screensaver"
SECTION = "x11/libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"
DEPENDS = "virtual/libx11 webkitgtk libpam libxxf86misc cinnamon-desktop libgnomekbd libxklavier"

inherit cinnamon autotools gettext pkgconfig

SRC_URI += "file://configure.ac.patch"

SRC_URI[md5sum] = "787c138c5dcb4d3b09a4d69d86214ad6"
SRC_URI[sha256sum] = "de32ab1852b605835ea0ca41f248d18b32d7805d479eb6fd5877d4de92dbb784"

EXTRA_OECONF = "--includedir=${STAGING_INCDIR} --libdir=${STAGING_LIBDIR}"

PACKAGES += "cinnamon-screensaver-data"

FILES_cinnamon-screensaver-data = " \
    ${datadir}/dbus-1/* \
"
