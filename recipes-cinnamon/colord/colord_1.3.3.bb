SUMMARY = "Colord"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
DEPENDS_class-native = "intltool-native lcms-native"
DEPENDS_class-target = "intltool-native colord-native gusb systemd lcms libgudev polkit"

SRC_URI_class-native = " \
    https://github.com/hughsie/colord/archive/${PV}.tar.gz \
  "
SRC_URI_class-target = " \
    https://github.com/hughsie/colord/archive/${PV}.tar.gz \
    file://use_native_binary.patch \
  "

SRC_URI[md5sum] = "0083ca2b3ccf54201eec84ec47209ca8"
SRC_URI[sha256sum] = "98a7bba6e2ab95bddf1939156d70ca96424e6086e1cdc4a8697768945e62ce65"

inherit autotools pkgconfig gtk-doc systemd gettext

EXTRA_OECONF = " \
    --disable-argyllcms-sensor \
    --enable-introspection=no \
"
EXTRA_OECONF_class-native = " \
    --disable-gusb \
    --disable-udev \
    --disable-bash-completion \
    --disable-polkit \
    --disable-systemd-login \
    --disable-argyllcms-sensor \
    --disable-session-helper \
"

PACKAGECONFIG_systemd[logind] = "--enable-logind"

do_configure_append () {
	# copy tools from the native colord build
	if [ "${PN}" != "colord-native" ]; then
                cp ${STAGING_BINDIR_NATIVE}/colord-${PV}/client/.libs/lt-cd-it8 client/lt-cd-it8-native
                cp ${STAGING_BINDIR_NATIVE}/colord-${PV}/client/.libs/lt-cd-create-profile client/lt-cd-create-profile-native
	fi
}

do_install_class-native () {
    install -d ${D}${bindir}/colord-${PV}/client/.libs
    install -m 755 client/.libs/lt-cd-it8 ${D}${bindir}/colord-${PV}/client/.libs/lt-cd-it8
    install -m 755 client/.libs/lt-cd-create-profile ${D}${bindir}/colord-${PV}/client/.libs/lt-cd-create-profile
}

PACKAGES =+ "libcolord"
FILES_libcolord = " \
    ${base_libdir}/systemd/* \
    ${libdir}/systemd/* \
    ${libdir}/tmpfiles.d/* \
    ${libdir}/colord-sensors/* \
    ${libdir}/colord-plugins/* \
    ${datadir}/dbus-1/* \
    ${datadir}/bash-completion/* \
    ${datadir}/color/* \
    ${datadir}/polkit-1/* \
    ${datadir}/glib-2.0/* \
"

BBCLASSEXTEND = "native"
