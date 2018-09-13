cmake_minimum_required(VERSION 3.8)
project(SphericalHarmonicsLighting)

set(CMAKE_CXX_STANDARD 11)

set(SOURCE_FILES
        framework/framework.cpp
        framework/framework.h
        framework/geometry.cpp
        framework/geometry.h
        framework/graphics.cpp
        framework/graphics.h
        framework/inputs.cpp
        framework/inputs.h
        framework-test/test.cpp
        sh_sampler/convert.cpp
        sh_sampler/convert.h
        sh_sampler/main.cpp
        sh_sampler/sphericalharmonics.cpp
        sh_sampler/sphericalharmonics.h
        spherical-harmonics-lighting/main.cpp)

add_executable(SphericalHarmonicsLighting ${SOURCE_FILES})