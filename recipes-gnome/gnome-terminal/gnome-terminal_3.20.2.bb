SUMMARY = "Display dialog boxes from the commandline and shell scripts"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"
DEPENDS = "gtk+ intltool-native dconf gsettings-desktop-schemas glib-2.0 startup-notification dbus-glib vte"

inherit gnomebase gettext pkgconfig

SRC_URI[archive.md5sum] = "8a450458cb833741cf52267d4a208f9a"
SRC_URI[archive.sha256sum] = "f5383060730f1de70af35e917f82d5b6a14d963ad9cfd6a0e705f90011645a23"

SRC_URI += "file://remove_yelp_macro.patch file://makefile_remove_yelp_macro.patch"

EXTRA_OECONF += "--disable-search-provider --without-nautilus-extension"

RRECOMMENDS_${PN} += "gnome-common-schemas"

FILES_${PN} += " \
    ${libdir}/systemd/user/* \
    ${datadir}/dbus-1/* \
    ${datadir}/appdata/* \
"
