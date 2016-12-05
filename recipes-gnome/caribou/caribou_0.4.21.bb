SUMMARY = "Display dialog boxes from the commandline and shell scripts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=e2aa4f66375a24019b0ff5e99cec40ad"
DEPENDS = "gtk+3 libgee intltool-native libxtst libxi libxml2 libxkbfile at-spi2-core libxklavier python3-pygobject"

inherit gnomebase gettext pkgconfig

SRC_URI[archive.md5sum] = "16b76cd7453b99e2871e8d4da88bf976"
SRC_URI[archive.sha256sum] = "9c43d9f4bd30f4fea7f780d4e8b14f7589107c52e9cb6bd202bd0d1c2064de55"

PACKAGES += "libcaribou"
FILES_libcaribou = " \
    ${libdir}/python2.7/* \
    ${libdir}/gtk-3.0/* \
    ${libdir}/gtk-2.0/* \
    ${libdir}/girepository-1.0/* \
    ${libdir}/gnome-settings-daemon-3.0/* \
    ${datadir}/dbus-1/* \
    ${datadir}/vala/* \
    ${datadir}/antler/* \
    ${datadir}/gir-1.0/* \
"
