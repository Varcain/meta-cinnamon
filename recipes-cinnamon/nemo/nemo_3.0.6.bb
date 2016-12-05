SUMMARY = "Nemo"
SECTION = "x11/libs"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=9e36112c2402ab6d70f4ce15a3d1db1c"
DEPENDS = "libxcursor libxrandr pixman libxrender libxkbfile libxfixes fontconfig cairo pango wayland freetype libpng at-spi2-atk atk libxdamage libepoxy libxcomposite gdk-pixbuf gtk+3 libnotify cinnamon-desktop"

inherit cinnamon autotools gettext gtk-doc pkgconfig gobject-introspection

SRC_URI[md5sum] = "0a67fa7147f8abf4a651f7fba43b70fe"
SRC_URI[sha256sum] = "3a2704e110a30625f9e807d21df44a577606d383c1eaf1ef4dae0e4dd321cdec"

SRC_URI += "file://makefile_fix.patch"

EXTRA_OECONF = "--disable-update-mimedb"

RRECOMMENDS_${PN} = "shared-mime-info"

PACKAGES += "nemo-data"

FILES_nemo-data += " \
    ${datadir}/icons/* \
    ${datadir}/dbus-1 \
    ${datadir}/mime/* \
    ${datadir}/polkit-1/* \
    ${datadir}/glib-2.0/* \
"
