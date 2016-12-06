SUMMARY = "Muffin"
SECTION = "x11"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8955bdc698cdc995fb6abba2cb6f7347"
DEPENDS = "virtual/libx11 gtk+3 cinnamon-desktop zenity clutter-1.0 cogl-1.0 gnome-doc-utils startup-notification libcanberra xcb-util libxinerama"
RDEPENDS_muffin = "zenity"

inherit cinnamon autotools gettext gtk-doc gobject-introspection pkgconfig update-alternatives

SRC_URI[md5sum] = "68b4bfcf83683c502f53e3d8074862c5"
SRC_URI[sha256sum] = "11c27abedad6952aaa446d37ad23e910c3c51dc0dd8d29298cfae2c3ad917e64"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
  # Fixup for set AC_CONFIG_MACRO_DIR but missing m4 directory
  mkdir --parents ${S}/m4
  export PATH=${PATH}:${STAGING_BINDIR}
}

do_install_prepend () {
    sed -i -e 's:-I${STAGING_DIR_TARGET}/usr/include:-I\$\{includedir\}:g' ${B}/src/muffin-plugins.pc
    sed -i -e 's:-I${STAGING_DIR_TARGET}/usr/lib:-I\$\{libdir\}:g' ${B}/src/muffin-plugins.pc
}

ALTERNATIVE_${PN} = "x-window-manager"
ALTERNATIVE_TARGET[x-window-manager] = "${bindir}/muffin"
ALTERNATIVE_PRIORITY[x-window-manager] = "30"

FILES_${PN} += " \
    ${datadir}/glib-2.0/* \
"
