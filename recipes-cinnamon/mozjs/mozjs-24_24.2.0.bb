SUMMARY = "SpiderMonkey is Mozilla's JavaScript engine written in C/C++"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=815ca599c9df247a0c7f619bab123dad"
DEPENDS = "python"

BPN = "mozjs"

SRC_URI = " \
    http://ftp.mozilla.org/pub/mozilla.org/js/${BPN}-${PV}.tar.bz2 \
    file://milestonepl.patch \
    file://jc.pc.in-fix.patch \
  "

SRC_URI[md5sum] = "5db79c10e049a2dc117a6e6a3bc78a8e"
SRC_URI[sha256sum] = "e62f3f331ddd90df1e238c09d61a505c516fe9fd8c5c95336611d191d18437d8"

S = "${WORKDIR}/${BPN}-${PV}/js/src"

inherit autotools perlnative pythonnative pkgconfig

DEPENDS += "nspr zlib"

# nspr's package-config is ignored so set libs manually
EXTRA_OECONF = " \
    --target=${TARGET_SYS} \
    --host=${BUILD_SYS} \
    --build=${BUILD_SYS} \
    --prefix=${prefix} \
    --libdir=${libdir} \
    --with-cross-lib=${libdir} \
    --disable-optimize \
    --enable-threadsafe \
    --enable-debug-symbols \
    --with-nspr-libs='-lplds4 -lplc4 -lnspr4' \
"

PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'x11', '', d)}"
PACKAGECONFIG[x11] = "--with-x --x-includes=${STAGING_INCDIR} --x-libraries=${STAGING_LIBDIR},--without-x,virtual/libx11"

# mozjs requires autoreconf 2.13
do_configure() {
    ( cd ${S}
      gnu-configize --force
      mv config.guess config.sub build/autoconf )
      SHELL=/bin/sh ${S}/configure ${EXTRA_OECONF}
}

PACKAGES =+ "lib${BPN}-24"
FILES_lib${BPN}-24 += "${libdir}/lib*.so"
FILES_${PN}-dev += "${bindir}/js24-config"
