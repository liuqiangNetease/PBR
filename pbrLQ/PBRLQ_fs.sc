#include "amplify_standard_head_fs.sh"
#include "amplify_compatible_unity_fs.sh"

uniform highp vec4 _Tint;
uniform sampler2D _MainTex;
uniform sampler2D _DetailTex;
uniform sampler2D _NormalMap;
uniform sampler2D _DetailNormalMap;
uniform highp float _BumpScale;
uniform highp float _DetailBumpScale;
uniform highp float _Metallic;
uniform highp float _Smoothness;
varying highp vec4 xlv_TEXCOORD0;
varying highp vec3 xlv_TEXCOORD1;
varying highp vec4 xlv_TEXCOORD2;
varying highp vec3 xlv_TEXCOORD4;
void main ()
{
  highp vec4 tmpvar_1 = vec4(0.0);
  highp vec3 specularTint_2 = vec3(0.0);
  highp vec3 albedo_3 = vec3(0.0);
  highp vec3 viewDir_4 = vec3(0.0);
  highp vec3 tangentSpaceNormal_5 = vec3(0.0);
  highp vec3 detailNormal_6 = vec3(0.0);
  highp vec3 mainNormal_7 = vec3(0.0);
  lowp vec4 tmpvar_8 = vec4(0.0);
  tmpvar_8 = texture2D (_NormalMap, xlv_TEXCOORD0.xy);
  mediump vec4 packednormal_9 = vec4(0.0);
  packednormal_9 = tmpvar_8;
  mediump float bumpScale_10 = 0.0;
  bumpScale_10 = _BumpScale;
  mediump vec3 normal_11 = vec3(0.0);
  normal_11 = ((packednormal_9.xyz * 2.0) - 1.0);
  normal_11.xy = (normal_11.xy * bumpScale_10);
  mainNormal_7 = normal_11;
  lowp vec4 tmpvar_12 = vec4(0.0);
  tmpvar_12 = texture2D (_DetailNormalMap, xlv_TEXCOORD0.zw);
  mediump vec4 packednormal_13 = vec4(0.0);
  packednormal_13 = tmpvar_12;
  mediump float bumpScale_14 = 0.0;
  bumpScale_14 = _DetailBumpScale;
  mediump vec3 normal_15 = vec3(0.0);
  normal_15 = ((packednormal_13.xyz * 2.0) - 1.0);
  normal_15.xy = (normal_15.xy * bumpScale_14);
  detailNormal_6 = normal_15;
  mediump vec3 n1_16 = vec3(0.0);
  n1_16 = mainNormal_7;
  mediump vec3 n2_17 = vec3(0.0);
  n2_17 = detailNormal_6;
  mediump vec3 tmpvar_18 = vec3(0.0);
  tmpvar_18.xy = (n1_16.xy + n2_17.xy);
  tmpvar_18.z = (n1_16.z * n2_17.z);
  mediump vec3 tmpvar_19 = vec3(0.0);
  tmpvar_19 = normalize(tmpvar_18);
  tangentSpaceNormal_5 = tmpvar_19;
  highp vec3 tmpvar_20 = vec3(0.0);
  tmpvar_20 = normalize(((
    (tangentSpaceNormal_5.x * xlv_TEXCOORD2)
  .xyz + 
    (tangentSpaceNormal_5.y * (((xlv_TEXCOORD1.yzx * xlv_TEXCOORD2.zxy) - (xlv_TEXCOORD1.zxy * xlv_TEXCOORD2.yzx)) * (xlv_TEXCOORD2.w * unity_WorldTransformParams.w)))
  ) + (tangentSpaceNormal_5.z * xlv_TEXCOORD1)));
  viewDir_4 = normalize((_WorldSpaceCameraPos - xlv_TEXCOORD4));
  lowp vec4 tmpvar_21 = vec4(0.0);
  tmpvar_21 = texture2D (_MainTex, xlv_TEXCOORD0.xy);
  lowp vec3 tmpvar_22 = vec3(0.0);
  tmpvar_22 = (texture2D (_DetailTex, xlv_TEXCOORD0.zw) * vec4(2.0, 2.0, 2.0, 2.0)).xyz;
  albedo_3 = ((tmpvar_21.xyz * _Tint.xyz) * tmpvar_22);
  mediump vec3 tmpvar_23 = vec3(0.0);
  mediump vec3 albedo_24 = vec3(0.0);
  albedo_24 = albedo_3;
  mediump float metallic_25 = 0.0;
  metallic_25 = _Metallic;
  mediump vec3 tmpvar_26 = vec3(0.0);
  tmpvar_26 = mix (vec3(0.2209163, 0.2209163, 0.2209163), albedo_24, vec3(metallic_25));
  tmpvar_23 = (albedo_24 * (0.7790837 - (metallic_25 * 0.7790837)));
  specularTint_2 = tmpvar_26;
  albedo_3 = tmpvar_23;
  mediump vec3 tmpvar_27 = vec3(0.0);
  mediump vec3 tmpvar_28 = vec3(0.0);
  tmpvar_28 = _WorldSpaceLightPos0.xyz;
  tmpvar_27 = _LightColor0.xyz;
  highp vec4 tmpvar_29 = vec4(0.0);
  tmpvar_29.w = 1.0;
  tmpvar_29.xyz = tmpvar_20;
  mediump vec4 normal_30 = vec4(0.0);
  normal_30 = tmpvar_29;
  mediump vec3 res_31 = vec3(0.0);
  mediump vec3 x_32 = vec3(0.0);
  x_32.x = dot (unity_SHAr, normal_30);
  x_32.y = dot (unity_SHAg, normal_30);
  x_32.z = dot (unity_SHAb, normal_30);
  mediump vec3 x1_33 = vec3(0.0);
  mediump vec4 tmpvar_34 = vec4(0.0);
  tmpvar_34 = (normal_30.xyzz * normal_30.yzzx);
  x1_33.x = dot (unity_SHBr, tmpvar_34);
  x1_33.y = dot (unity_SHBg, tmpvar_34);
  x1_33.z = dot (unity_SHBb, tmpvar_34);
  res_31 = (x_32 + (x1_33 + (unity_SHC.xyz * 
    ((normal_30.x * normal_30.x) - (normal_30.y * normal_30.y))
  )));
  mediump vec3 tmpvar_35 = vec3(0.0);
  tmpvar_35 = max (((1.055 * 
    pow (max (res_31, vec3(0.0, 0.0, 0.0)), vec3(0.4166667, 0.4166667, 0.4166667))
  ) - 0.055), vec3(0.0, 0.0, 0.0));
  res_31 = tmpvar_35;
  mediump vec3 diffColor_36 = vec3(0.0);
  diffColor_36 = albedo_3;
  mediump vec3 specColor_37 = vec3(0.0);
  specColor_37 = specularTint_2;
  mediump float smoothness_38 = 0.0;
  smoothness_38 = _Smoothness;
  mediump vec3 normal_39 = vec3(0.0);
  normal_39 = tmpvar_20;
  mediump vec3 viewDir_40 = vec3(0.0);
  viewDir_40 = viewDir_4;
  mediump vec3 tmpvar_41 = vec3(0.0);
  mediump vec3 inVec_42 = vec3(0.0);
  inVec_42 = (tmpvar_28 + viewDir_40);
  tmpvar_41 = (inVec_42 * inversesqrt(max (0.001, 
    dot (inVec_42, inVec_42)
  )));
  mediump float tmpvar_43 = 0.0;
  tmpvar_43 = clamp (dot (normal_39, tmpvar_41), 0.0, 1.0);
  mediump float tmpvar_44 = 0.0;
  tmpvar_44 = (1.0 - smoothness_38);
  mediump float tmpvar_45 = 0.0;
  tmpvar_45 = (tmpvar_44 * tmpvar_44);
  mediump vec4 tmpvar_46 = vec4(0.0);
  tmpvar_46.w = 1.0;
  tmpvar_46.xyz = (((
    (diffColor_36 + ((tmpvar_45 / (
      (max (0.32, clamp (dot (tmpvar_28, tmpvar_41), 0.0, 1.0)) * (1.5 + tmpvar_45))
     * 
      (((tmpvar_43 * tmpvar_43) * ((tmpvar_45 * tmpvar_45) - 1.0)) + 1.00001)
    )) * specColor_37))
   * tmpvar_27) * clamp (
    dot (normal_39, tmpvar_28)
  , 0.0, 1.0)) + (max (vec3(0.0, 0.0, 0.0), tmpvar_35) * diffColor_36));
  tmpvar_1 = tmpvar_46;
  gl_FragData[0] = tmpvar_1;
}


