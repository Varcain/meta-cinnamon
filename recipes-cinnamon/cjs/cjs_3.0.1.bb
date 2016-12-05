SUMMARY = "cjs"
SECTION = "x11/libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=e7436dd55d7c05a5fa18f8cab10b3a6b"
DEPENDS = "mozjs-24 cairo harfbuzz pango gtk+3 gdk-pixbuf atk"

inherit cinnamon autotools gettext gobject-introspection

SRC_URI += " \
    file://configure.ac.patch \
"

SRC_URI[md5sum] = "884bc8e2739a086546b2cdc45e7fdad1"
SRC_URI[sha256sum] = "cafda5a8a21421e93720732debeea08c59e63c058d240ab0f7b3a6969654864f"

INSANE_SKIP_cjs += "dev-deps"
