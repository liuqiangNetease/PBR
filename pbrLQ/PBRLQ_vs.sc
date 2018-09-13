#include "amplify_standard_head_vs.sh"
#include "amplify_compatible_unity_vs.sh"

uniform highp vec4 _MainTex_ST;
uniform highp vec4 _DetailTex_ST;
varying highp vec4 xlv_TEXCOORD0;
varying highp vec3 xlv_TEXCOORD1;
varying highp vec4 xlv_TEXCOORD2;
varying highp vec3 xlv_TEXCOORD4;
void main ()
{
  highp vec4 tmpvar_1 = vec4(0.0);
  highp vec4 tmpvar_2 = vec4(0.0);
  tmpvar_2.w = 1.0;
  tmpvar_2.xyz = _glesVertex.xyz;
  highp mat3 tmpvar_3;
  tmpvar_3[0] = unity_WorldToObject[0].xyz;
  tmpvar_3[1] = unity_WorldToObject[1].xyz;
  tmpvar_3[2] = unity_WorldToObject[2].xyz;
  highp mat3 tmpvar_4;
  tmpvar_4[0] = unity_ObjectToWorld[0].xyz;
  tmpvar_4[1] = unity_ObjectToWorld[1].xyz;
  tmpvar_4[2] = unity_ObjectToWorld[2].xyz;
  highp vec4 tmpvar_5 = vec4(0.0);
  tmpvar_5.xyz = normalize((tmpvar_4 * _glesTANGENT.xyz));
  tmpvar_5.w = _glesTANGENT.w;
  tmpvar_1.xy = ((_glesMultiTexCoord0.xy * _MainTex_ST.xy) + _MainTex_ST.zw);
  tmpvar_1.zw = ((_glesMultiTexCoord0.xy * _DetailTex_ST.xy) + _DetailTex_ST.zw);
  gl_Position = (unity_MatrixVP * (unity_ObjectToWorld * tmpvar_2));
  xlv_TEXCOORD0 = tmpvar_1;
  xlv_TEXCOORD1 = normalize((_glesNormal * tmpvar_3));
  xlv_TEXCOORD2 = tmpvar_5;
  xlv_TEXCOORD4 = (unity_ObjectToWorld * _glesVertex).xyz;
}


