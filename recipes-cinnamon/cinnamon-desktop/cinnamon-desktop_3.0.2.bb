SUMMARY = "Cinnamon Desktop library"
SECTION = "x11/libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS = "gtk+3 libxkbfile pulseaudio"

inherit cinnamon autotools gettext gobject-introspection

SRC_URI[md5sum] = "65bae7ab86ca8e8ec9491687c3574a48"
SRC_URI[sha256sum] = "a8bbf148b9ee25f21fb2c196a54c95eeee7e35cd23b32f25919516f08e8f4dda"

FILES_${PN} += " \
    ${datadir}/glib-2.0/* \
    ${datadir}/libcinnamon-desktop/* \
"
