SUMMARY = "GNOME keyboard library"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=6e29c688d912da12b66b73e32b03d812"

SECTION = "x11/gnome/libs"

DEPENDS = "gconf gtk+3 libxklavier intltool-native"

inherit gnome

SRC_URI[archive.md5sum] = "2f000ed5aa11454936c846a784e484c7"
SRC_URI[archive.sha256sum] = "c41ea5b0f64da470925ba09f9f1b46b26b82d4e433e594b2c71eab3da8856a09"
GNOME_COMPRESS_TYPE="xz"

EXTRA_OECONF = " \
    --enable-introspection=no \
"

#do_configure_append() {
#    find ${B} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
#    find ${B} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
#}

