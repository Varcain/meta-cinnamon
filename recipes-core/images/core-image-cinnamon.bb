DESCRIPTION = "A Cinnamon minimal demo image."

IMAGE_FEATURES += "splash x11 ssh-server-dropbear"

IMAGE_INSTALL = "packagegroup-core-boot \
    ${ROOTFS_PKGMANAGE_BOOTSTRAP} \
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-utils \
    dbus \
    packagegroup-cinnamon \
    kernel-modules \
"

REQUIRED_DISTRO_FEATURES = "x11"

IMAGE_LINGUAS ?= " "

LICENSE = "MIT"

export IMAGE_BASENAME = "core-image-cinnamon"

inherit core-image
