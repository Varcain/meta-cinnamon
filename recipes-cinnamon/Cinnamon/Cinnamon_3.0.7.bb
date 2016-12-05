SUMMARY = "Cinnamon Desktop"
SECTION = "x11"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=0159e10ccad3751f827b6741af79417b"
DEPENDS = "muffin cjs cinnamon-menus startup-notification libsoup-2.4 networkmanager libgnome-keyring libcroco gdk-pixbuf pixman"
RDEPENDS_Cinnamon = "python adwaita-icon-theme"
RCONFLICTS_${PN} = "matchbox-common mini-x-session matchbox-session"

inherit cinnamon autotools gettext gtk-doc pkgconfig gobject-introspection

SRC_URI += " \
    file://configure.patch \
    file://gir_fixup.patch \
    file://fix_python_runtime.patch \
"

SRC_URI[md5sum] = "bdfdf91477f4f1b5ff58a9238b4b5e9b"
SRC_URI[sha256sum] = "0aa0ce174a4638f54ddb2f0dc1f93a847678fa225c7a4fae718ffd14f1c8694f"

EXTRA_OECONF = "--enable-introspection=yes"

do_configure_prepend() {
  # Fixup for set AC_CONFIG_MACRO_DIR but missing m4 directory
  mkdir --parents ${S}/m4
}

do_compile_prepend() {
  mkdir --parents ${B}/files
  cp -r ${S}/files/usr ${S}/files/etc ${B}/files
}

PACKAGES += "Cinnamon-data"

FILES_Cinnamon-data = " \
    ${libdir}/cinnamon/* \
    ${datadir}/icons/* \
    ${datadir}/cinnamon/* \
    ${datadir}/dbus-1/* \
    ${datadir}/glib-2.0/* \
    ${datadir}/xsessions/* \
    ${datadir}/desktop-directories/* \
    ${datadir}/cinnamon-session/* \
    ${datadir}/polkit-1/* \
"
