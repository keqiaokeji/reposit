(function(){var m=this,aa=function(a){var b=typeof a;if("object"==b)if(a){if(a instanceof Array)return"array";if(a instanceof Object)return b;var c=Object.prototype.toString.call(a);if("[object Window]"==c)return"object";if("[object Array]"==c||"number"==typeof a.length&&"undefined"!=typeof a.splice&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("splice"))return"array";if("[object Function]"==c||"undefined"!=typeof a.call&&"undefined"!=typeof a.propertyIsEnumerable&&!a.propertyIsEnumerable("call"))return"function"}else return"null";
else if("function"==b&&"undefined"==typeof a.call)return"object";return b},ba=function(a,b,c){return a.call.apply(a.bind,arguments)},ca=function(a,b,c){if(!a)throw Error();if(2<arguments.length){var d=Array.prototype.slice.call(arguments,2);return function(){var c=Array.prototype.slice.call(arguments);Array.prototype.unshift.apply(c,d);return a.apply(b,c)}}return function(){return a.apply(b,arguments)}},n=function(a,b,c){n=Function.prototype.bind&&-1!=Function.prototype.bind.toString().indexOf("native code")?
ba:ca;return n.apply(null,arguments)};var s=(new Date).getTime();var da=function(){},v=function(a,b,c){switch(typeof b){case "string":ea(b,c);break;case "number":c.push(isFinite(b)&&!isNaN(b)?b:"null");break;case "boolean":c.push(b);break;case "undefined":c.push("null");break;case "object":if(null==b){c.push("null");break}if(b instanceof Array){var d=b.length;c.push("[");for(var f="",e=0;e<d;e++)c.push(f),v(a,b[e],c),f=",";c.push("]");break}c.push("{");d="";for(f in b)b.hasOwnProperty(f)&&(e=b[f],"function"!=typeof e&&(c.push(d),ea(f,c),c.push(":"),v(a,e,c),d=
","));c.push("}");break;case "function":break;default:throw Error("Unknown type: "+typeof b);}},w={'"':'\\"',"\\":"\\\\","/":"\\/","\b":"\\b","\f":"\\f","\n":"\\n","\r":"\\r","\t":"\\t","\x0B":"\\u000b"},fa=/\uffff/.test("\uffff")?/[\\\"\x00-\x1f\x7f-\uffff]/g:/[\\\"\x00-\x1f\x7f-\xff]/g,ea=function(a,b){b.push('"');b.push(a.replace(fa,function(a){if(a in w)return w[a];var b=a.charCodeAt(0),f="\\u";16>b?f+="000":256>b?f+="00":4096>b&&(f+="0");return w[a]=f+b.toString(16)}));b.push('"')};var ga=/&/g,ha=/</g,ia=/>/g,ja=/"/g,ka=/'/g,la=/\x00/g,y={"\x00":"\\0","\b":"\\b","\f":"\\f","\n":"\\n","\r":"\\r","\t":"\\t","\x0B":"\\x0B",'"':'\\"',"\\":"\\\\"},B={"'":"\\'"};var C=function(a){C[" "](a);return a};C[" "]=function(){};var D=function(a){try{var b;if(b=!!a&&null!=a.location.href)t:{try{C(a.foo);b=!0;break t}catch(c){}b=!1}return b}catch(d){return!1}};var ma=document,E=window;var F=function(a,b){for(var c in a)Object.prototype.hasOwnProperty.call(a,c)&&b.call(null,a[c],c,a)},G=function(a){return!!a&&"function"==typeof a&&!!a.call},na=function(a,b){if(!(2>arguments.length))for(var c=1,d=arguments.length;c<d;++c)a.push(arguments[c])},H=function(a,b){if(!(1E-4>Math.random())){var c=Math.random();if(c<b){try{var d=new Uint16Array(1);window.crypto.getRandomValues(d);c=d[0]/65536}catch(f){c=Math.random()}return a[Math.floor(c*a.length)]}}return null},oa=function(a){a.google_unique_id?
++a.google_unique_id:a.google_unique_id=1},I=function(a){a=a.google_unique_id;return"number"==typeof a?a:0},J=function(a){var b=a.length;if(0==b)return 0;for(var c=305419896,d=0;d<b;d++)c^=(c<<5)+(c>>2)+a.charCodeAt(d)&4294967295;return 0<c?c:4294967296+c},pa=function(a){for(var b=[],c=0;a&&25>c;++c){var d=9!=a.nodeType&&a.id,d=d?"/"+d:"",f;t:{var e=a.parentElement;f=a.nodeName.toLowerCase();if(e)for(var e=e.childNodes,g=0,h=0;h<e.length;++h){var k=e[h];if(k.nodeName&&k.nodeName.toLowerCase()==f){if(a==
k){f="."+g;break t}++g}}f=""}b.push((a.nodeName&&a.nodeName.toLowerCase())+d+f);a=a.parentElement}return b.join()},qa=function(a){var b=[];if(a)try{for(var c=a.parent,d=0;c&&c!=a&&25>d;++d){for(var f=c.frames,e=0;e<f.length;++e)if(a==f[e]){b.push(e);break}a=c;c=a.parent}}catch(g){}return b.join()},K=function(a,b){return b.getComputedStyle?b.getComputedStyle(a,null):a.currentStyle},ra=function(a,b,c,d){c=[c.google_ad_slot,c.google_ad_format,c.google_ad_type,c.google_ad_width,c.google_ad_height];if(d){a=
[];for(d=0;b&&25>d;b=b.parentNode,++d)a.push(9!=b.nodeType&&b.id||"");(b=a.join())&&c.push(b)}else c.push(pa(b)),c.push(qa(a));return J(c.join(":")).toString()};var sa={google_analytics_domain_name:!0,google_analytics_uacct:!0},ta=function(a){a.google_page_url&&(a.google_page_url=String(a.google_page_url));var b=[];F(a,function(a,d){if(null!=a){var f;try{var e=[];v(new da,a,e);f=e.join("")}catch(g){}f&&na(b,d,"=",f,";")}});return b.join("")};var L=function(a){a=parseFloat(a);return isNaN(a)||1<a||0>a?0:a},ua=/^([\w-]+\.)*([\w-]{2,})(\:[0-9]+)?$/,va=function(a,b){if(!a)return b;var c=a.match(ua);return c?c[0]:b};var wa=L("0.15"),xa=L("0.001"),ya=L("0.001"),za=L("0.2"),Aa=L("0.03");var Ba=/^true$/.test("false")?!0:!1;var Ca=!!window.google_async_iframe_id,Da=function(a,b,c){var d=["<iframe"],f;for(f in a)a.hasOwnProperty(f)&&na(d,f+"="+a[f]);d.push('style="left:0;position:absolute;top:0;"');d.push("></iframe>");b="border:none;height:"+c+"px;margin:0;padding:0;position:relative;visibility:visible;width:"+b+"px;background-color:transparent";return['<ins style="display:inline-table;',b,'"><ins id="',a.id+"_anchor",'" style="display:block;',b,'">',d.join(" "),"</ins></ins>"].join("")};var N=!0,Ea={},Fa=function(a){var b=a.toString();a.name&&-1==b.indexOf(a.name)&&(b+=": "+a.name);a.message&&-1==b.indexOf(a.message)&&(b+=": "+a.message);if(a.stack){a=a.stack;var c=b;try{-1==a.indexOf(c)&&(a=c+"\n"+a);for(var d;a!=d;)d=a,a=a.replace(/((https?:\/..*\/)[^\/:]*:\d+(?:.|\n)*)\2/,"$1");b=a.replace(/\n */g,"\n")}catch(f){b=c}}return b},Ia=function(a,b,c,d){var f=Ga,e,g=N;try{e=b()}catch(h){try{var k=Fa(h);b="";h.fileName&&(b=h.fileName);var l=-1;h.lineNumber&&(l=h.lineNumber);var r;t:{try{r=
c?c():"";break t}catch(p){}r=""}g=f(a,k,b,l,r)}catch(q){try{var M=Fa(q);a="";q.fileName&&(a=q.fileName);c=-1;q.lineNumber&&(c=q.lineNumber);Ga("pAR",M,a,c,void 0,void 0)}catch(x){Ha({context:"mRE",msg:x.toString()+"\n"+(x.stack||"")},void 0)}}if(!g)throw h;}finally{if(d)try{d()}catch(A){}}return e},Ga=function(a,b,c,d,f,e){a={context:a,msg:b.substring(0,512),eid:f&&f.substring(0,40),file:c,line:d.toString(),url:ma.URL.substring(0,512),ref:ma.referrer.substring(0,512)};Ja(a);Ha(a,e);return N},Ha=function(a,
b){try{if(Math.random()<(b||.01)){var c="/pagead/gen_204?id=jserror"+Ka(a),d="http"+("https:"==E.location.protocol?"s":"")+"://pagead2.googlesyndication.com"+c,c=d=d.substring(0,2E3);E.google_image_requests||(E.google_image_requests=[]);var f=E.document.createElement("img");f.src=c;E.google_image_requests.push(f)}}catch(e){}},Ja=function(a){var b=a||{};F(Ea,function(a,d){b[d]=E[a]})},La=function(a,b){return function(){var c=arguments;return Ia(a,function(){return b.apply(void 0,c)},void 0,void 0)}},
O=function(a,b){return La(a,b)},Ka=function(a){var b="";F(a,function(a,d){if(0===a||a)b+="&"+d+"="+("function"==typeof encodeURIComponent?encodeURIComponent(a):escape(a))});return b};var P=null,Ma=function(){if(!P){for(var a=window,b=a,c=0;a!=a.parent;)if(a=a.parent,c++,D(a))b=a;else break;P=b}return P};N=!/^true$/.test("false");Ea={client:"google_ad_client",format:"google_ad_format",slotname:"google_ad_slot",output:"google_ad_output",ad_type:"google_ad_type",async_oa:"google_async_for_oa_experiment",dimpr:"google_always_use_delayed_impressions_experiment",peri:"google_top_experiment",pse:"google_pstate_expt"};var Q=/^([0-9.]+)px$/,Na=/^([0-9.]+)$/,R=[{width:120,height:240,format:"vertical"},{width:120,height:600,format:"vertical"},{width:125,height:125,format:"rectangle"},{width:160,height:600,format:"vertical"},{width:180,height:150,format:"rectangle"},{width:200,height:200,format:"rectangle"},{width:234,height:60,format:"horizontal"},{width:250,height:250,format:"rectangle"},{width:300,height:250,format:"rectangle"},{width:300,height:600,format:"vertical"},{width:320,height:50,format:"horizontal"},{width:336,
height:280,format:"rectangle"},{width:468,height:60,format:"horizontal"},{width:728,height:90,format:"horizontal"},{width:970,height:90,format:"horizontal"}],Oa=function(a,b){for(var c=["width","height"],d=0;d<c.length;d++){var f="google_ad_"+c[d];if(!b.hasOwnProperty(f)){var e;e=(e=Q.exec(a[c[d]]))?Number(e[1]):null;null!=e&&(b[f]=Math.round(e))}}},Qa=function(a,b,c){R.sort(function(a,b){return a.width-b.width||a.height-b.height});"auto"==b&&(b=Pa(c),b=Math.min(1200,b),b=.25>=a/b?"vertical":"horizontal,rectangle");
for(c=R.length;c--;)if(R[c].width<=a&&-1!=b.indexOf(R[c].format))return R[c];return null},Pa=function(a){a=a.document;return a.documentElement.clientWidth||a.body.clientWidth};var S=function(a,b,c){c||(c=Ba?"https":"http");return[c,"://",a,b].join("")};var T=null;var U=function(a){this.b=a;a.google_iframe_oncopy||(a.google_iframe_oncopy={handlers:{},upd:n(this.m,this)});this.j=a.google_iframe_oncopy},Ra;var V="var i=this.id,s=window.google_iframe_oncopy,H=s&&s.handlers,h=H&&H[i],w=this.contentWindow,d;try{d=w.document}catch(e){}if(h&&d&&(!d.body||!d.body.firstChild)){if(h.call){setTimeout(h,0)}else if(h.match){try{h=s.upd(h,i)}catch(e){}w.location.replace(h)}}";
/[\x00&<>"']/.test(V)&&(-1!=V.indexOf("&")&&(V=V.replace(ga,"&amp;")),-1!=V.indexOf("<")&&(V=V.replace(ha,"&lt;")),-1!=V.indexOf(">")&&(V=V.replace(ia,"&gt;")),-1!=V.indexOf('"')&&(V=V.replace(ja,"&quot;")),-1!=V.indexOf("'")&&(V=V.replace(ka,"&#39;")),-1!=V.indexOf("\x00")&&(V=V.replace(la,"&#0;")));Ra=V;U.prototype.set=function(a,b){this.j.handlers[a]=b;this.b.addEventListener&&this.b.addEventListener("load",n(this.k,this,a),!1)};
U.prototype.k=function(a){a=this.b.document.getElementById(a);try{var b=a.contentWindow.document;if(a.onload&&b&&(!b.body||!b.body.firstChild))a.onload()}catch(c){}};U.prototype.m=function(a,b){var c=Sa("rx",a),d;t:{if(a&&(d=a.match("dt=([^&]+)"))&&2==d.length){d=d[1];break t}d=""}d=(new Date).getTime()-d;c=c.replace(/&dtd=(\d+|M)/,"&dtd="+(1E4>d?d+"":"M"));this.set(b,c);return c};var Sa=function(a,b){var c=new RegExp("\\b"+a+"=(\\d+)"),d=c.exec(b);d&&(b=b.replace(c,a+"="+(+d[1]+1||1)));return b};var W;t:{var Ta=m.navigator;if(Ta){var Ua=Ta.userAgent;if(Ua){W=Ua;break t}}W=""}var X=function(a){return-1!=W.indexOf(a)};var Va=X("Opera")||X("OPR"),Wa=X("Trident")||X("MSIE"),Xa=X("Gecko")&&-1==W.toLowerCase().indexOf("webkit")&&!(X("Trident")||X("MSIE")),Ya=-1!=W.toLowerCase().indexOf("webkit");(function(){var a="",b;if(Va&&m.opera)return a=m.opera.version,"function"==aa(a)?a():a;Xa?b=/rv\:([^\);]+)(\)|;)/:Wa?b=/\b(?:MSIE|rv)[: ]([^\);]+)(\)|;)/:Ya&&(b=/WebKit\/(\S+)/);b&&(a=(a=b.exec(W))?a[1]:"");return Wa&&(b=(b=m.document)?b.documentMode:void 0,b>parseFloat(a))?String(b):a})();var Y,Z=function(a){this.c=[];this.b=a||window;this.a=0;this.d=null;this.e=0},Za=function(a,b){this.l=a;this.i=b};Z.prototype.o=function(a,b){0!=this.a||0!=this.c.length||b&&b!=window?this.h(a,b):(this.a=2,this.g(new Za(a,window)))};Z.prototype.h=function(a,b){this.c.push(new Za(a,b||this.b));$(this)};Z.prototype.p=function(a){this.a=1;if(a){var b=O("sjr::timeout",n(this.f,this,!0));this.d=this.b.setTimeout(b,a)}};
Z.prototype.f=function(a){a&&++this.e;1==this.a&&(null!=this.d&&(this.b.clearTimeout(this.d),this.d=null),this.a=0);$(this)};Z.prototype.q=function(){return!(!window||!Array)};Z.prototype.r=function(){return this.e};Z.prototype.nq=Z.prototype.o;Z.prototype.nqa=Z.prototype.h;Z.prototype.al=Z.prototype.p;Z.prototype.rl=Z.prototype.f;Z.prototype.sz=Z.prototype.q;Z.prototype.tc=Z.prototype.r;var $=function(a){var b=O("sjr::tryrun",n(a.n,a));a.b.setTimeout(b,0)};
Z.prototype.n=function(){if(0==this.a&&this.c.length){var a=this.c.shift();this.a=2;var b=O("sjr::run",n(this.g,this,a));a.i.setTimeout(b,0);$(this)}};Z.prototype.g=function(a){this.a=0;a.l()};
var $a=function(a){try{return a.sz()}catch(b){return!1}},ab=function(a){return!!a&&("object"==typeof a||"function"==typeof a)&&$a(a)&&G(a.nq)&&G(a.nqa)&&G(a.al)&&G(a.rl)},bb=function(){if(Y&&$a(Y))return Y;var a=Ma(),b=a.google_jobrunner;return ab(b)?Y=b:a.google_jobrunner=Y=new Z(a)},cb=function(a,b){bb().nq(a,b)},db=function(a,b){bb().nqa(a,b)};var eb={"120x90":!0,"160x90":!0,"180x90":!0,"200x90":!0,"468x15":!0,"728x15":!0},fb=Ca?1==I(E):!I(E),gb=function(){var a=C("script");return["<",a,' src="',S(va("","pagead2.googlesyndication.com"),"/pagead/js/r20140520/r20140417/show_ads_impl.js",""),'"></',a,">"].join("")},hb=function(a,b,c,d){return function(){var f=!1;d&&bb().al(3E4);
var e=a.document.getElementById(b);e&&!D(e.contentWindow)&&3==a.google_top_js_status&&(a.google_top_js_status=6);try{if(D(a.document.getElementById(b).contentWindow)){var g=a.document.getElementById(b).contentWindow,h=g.document;h.body&&h.body.firstChild||(h.open(),g.google_async_iframe_close=!0,h.write(c))}else{var k=a.document.getElementById(b).contentWindow,l;e=c;e=String(e);if(e.quote)l=e.quote();else{g=['"'];for(h=0;h<e.length;h++){var r=e.charAt(h),p=r.charCodeAt(0),q=g,M=h+1,x;if(!(x=y[r])){var A;
if(31<p&&127>p)A=r;else{var u=r;if(u in B)A=B[u];else if(u in y)A=B[u]=y[u];else{var t=u,z=u.charCodeAt(0);if(31<z&&127>z)t=u;else{if(256>z){if(t="\\x",16>z||256<z)t+="0"}else t="\\u",4096>z&&(t+="0");t+=z.toString(16).toUpperCase()}A=B[u]=t}}x=A}q[M]=x}g.push('"');l=g.join("")}k.location.replace("javascript:"+l)}f=!0}catch(vb){k=Ma().google_jobrunner,ab(k)&&k.rl()}f&&(f=Sa("google_async_rrc",c),(new U(a)).set(b,hb(a,b,f,!1)))}},ib=function(a){var b=["<iframe"];F(a,function(a,d){null!=a&&b.push(" "+
d+'="'+a+'"')});b.push("></iframe>");return b.join("")},jb=function(a,b,c,d){d=d?'"':"";var f=d+"0"+d;a.width=d+b+d;a.height=d+c+d;a.frameborder=f;a.marginwidth=f;a.marginheight=f;a.vspace=f;a.hspace=f;a.allowtransparency=d+"true"+d;a.scrolling=d+"no"+d},lb=function(a,b,c){kb(a,b,c,function(a,b,e){a=a.document;for(var g=b.id,h=0;!g||a.getElementById(g);)g="aswift_"+h++;b.id=g;b.name=g;g=Number(e.google_ad_width);h=Number(e.google_ad_height);16==e.google_reactive_ad_format?(e=a.createElement("div"),
e.innerHTML=Da(b,g,h),c.appendChild(e.firstChild)):c.innerHTML=Da(b,g,h);return b.id})},kb=function(a,b,c,d){var f=C("script"),e={};jb(e,b.google_ad_width,b.google_ad_height,!0);e.onload='"'+Ra+'"';d=d(a,e,b);e=b.google_override_format||!eb[b.google_ad_width+"x"+b.google_ad_height]&&"aa"==b.google_loader_used?H(["c","e"],za):null;var g=b.google_ad_output,h=b.google_ad_format;h||"html"!=g&&null!=g||(h=b.google_ad_width+"x"+b.google_ad_height,"e"==e&&(h+="_as"));g=!b.google_ad_slot||b.google_override_format||
!eb[b.google_ad_width+"x"+b.google_ad_height]&&"aa"==b.google_loader_used;h=h&&g?h.toLowerCase():"";b.google_ad_format=h;h=ra(null,c,b,!0);b.google_ad_unit_key=h;h=a.google_adk2_experiment=a.google_adk2_experiment||H(["C","E"],ya)||"N";if("E"==h){b.google_ad_unit_key_2=ra(a,c,b);h=[b.google_ad_slot,b.google_ad_type];b.google_ad_unit_key_var=J(h.join());g=qa(a);h.push(g);b.google_ad_unit_key_win=J(g);g=pa(c);h.push(g);b.google_ad_unit_key_dom=J(g);g=[b.google_ad_width,b.google_ad_height];if(c&&a&&
(c=K(c,a))){var k=(c.display||"inline").replace("none","inline"),l=c.position||"static",r=c.cssFloat||c.styleFloat||"none";g.push(l);"static"==l||"relative"==l?(g.push("none"==r?k:""),g.push(r)):(g.push(""),g.push(""));if("static"!=l)for(k=["top","bottom","left","right"],l=0;l<k.length;l++)r=c[k[l]],g.push(r&&"auto"!=r?r:"")}b.google_ad_unit_key_css=J(g.join());b.google_ad_unit_key_3=J(h.join(":"))}else"C"==h&&(b.google_ad_unit_key_2="ctrl");b=ta(b);var p;if(c=fb){if(!T)r:{h=[E.top];c=[];for(g=0;k=
h[g++];){c.push(k);try{if(k.frames)for(var q=k.frames.length,l=0;l<q&&1024>h.length;++l)h.push(k.frames[l])}catch(M){}}for(q=0;q<c.length;q++)try{if(p=c[q].frames.google_esf){T=p;break r}}catch(x){}T=null}c=!T}c?(p={},jb(p,0,0,!1),p.style="display:none",p.id="google_esf",p.name="google_esf",p.src=S(va("","googleads.g.doubleclick.net"),"/pagead/html/r20140520/r20140417/zrt_lookup.html"),p=ib(p)):p=
"";q=(new Date).getTime();c=a.google_top_experiment;h=a.google_async_for_oa_experiment;g=a.google_always_use_delayed_impressions_experiment;k=a.google_per_pub_expt_branch;l=a.google_available_width_experiment;e=["<!doctype html><html><body>",p,"<",f,">",b,"google_show_ads_impl=true;google_unique_id=",a.google_unique_id,';google_async_iframe_id="',d,'";google_start_time=',s,";",c?'google_top_experiment="'+c+'";':"",h?'google_async_for_oa_experiment="'+h+'";':"",g?'google_always_use_delayed_impressions_experiment="'+
g+'";':"",e?'google_append_as_for_format_override="'+e+'";':"",k?'google_per_pub_expt_branch="'+k+'";':"",l?'google_available_width_experiment="'+l+'";':"","google_bpp=",q>s?q-s:1,";google_async_rrc=0;</",f,">",gb(),"</body></html>"].join("");(a.document.getElementById(d)?cb:db)(hb(a,d,e,!0))},mb=Math.floor(1E6*Math.random()),nb=function(a){for(var b=a.data.split("\n"),c={},d=0;d<b.length;d++){var f=b[d].indexOf("=");-1!=f&&(c[b[d].substr(0,f)]=b[d].substr(f+1))}b=c[3];if(c[1]==mb&&(window.google_top_js_status=
4,a.source==top&&0==b.indexOf(a.origin)&&(window.google_top_values=c,window.google_top_js_status=5),window.google_top_js_callbacks)){for(a=0;a<window.google_top_js_callbacks.length;a++)window.google_top_js_callbacks[a]();window.google_top_js_callbacks.length=0}},ob=function(a,b){var c=navigator;if(a&&b&&c){try{var d=J([b,c.plugins&&c.plugins.length,a.screen&&a.screen.height,(new Date).getTimezoneOffset(),c.userAgent].join())}catch(f){return}c=d/4294967296;if(c<Aa){a.google_per_pub_expt_branch=1>c/
Aa*3?"42631042":H(["42631041","42631040"],1);var d=a.document,c=d.createElement("script"),e;(e=b)?(e=e.toLowerCase())&&"ca-"!=e.substring(0,3)&&(e="ca-"+e):e="";c.async=!0;c.type="text/javascript";c.src=S("www.gstatic.com","/pub-config/"+e+".js");"42631040"!=a.google_per_pub_expt_branch&&(d=d.getElementsByTagName("script")[0],d.parentNode.insertBefore(c,d))}}};var pb=function(a){return/(^| )adsbygoogle($| )/.test(a.className)&&"done"!=a.getAttribute("data-adsbygoogle-status")},rb=function(a,b,c){oa(c);qb(a,b,c);var d=K(a,c);if(!d||"none"!=d.display||"on"==b.google_adtest||0<b.google_reactive_ad_format){1==I(c)&&ob(c,b.google_ad_client);F(sa,function(a,d){b[d]=b[d]||c[d]});b.google_loader_used="aa";if((d=b.google_ad_output)&&"html"!=d)throw Error("No support for google_ad_output="+d);Ia("aa::main",function(){lb(c,b,a)})}else c.document.createComment&&a.appendChild(c.document.createComment("No ad requested because of display:none on the adsbygoogle tag"))},
qb=function(a,b,c){for(var d=a.attributes,f=d.length,e=0;e<f;e++){var g=d[e];if(/data-/.test(g.nodeName)){var h=g.nodeName.replace("data","google").replace(/-/g,"_");b.hasOwnProperty(h)||(g=g.nodeValue,"google_reactive_ad_format"==h&&(g=+g,g=isNaN(g)?null:g),null===g||(b[h]=g))}}if(1==b.google_reactive_ad_format)b.google_ad_width=320,b.google_ad_height=50,a.style.display="none";else if(8==b.google_reactive_ad_format)d=c.document,b.google_ad_width=("CSS1Compat"==d.compatMode?d.documentElement:d.body).clientWidth,
c=c.document,b.google_ad_height=Math.max(("CSS1Compat"==c.compatMode?c.documentElement:c.body).clientHeight-200,200),a.style.display="none";else if(d=b.google_ad_format,"auto"==d||/^((^|,) *(horizontal|vertical|rectangle) *)+$/.test(d)){d=a.offsetWidth;f=b.google_ad_format;c=Qa(d,f,c);if(!c)throw Error("Cannot find a responsive size for a container of width="+d+"px and data-ad-format="+f);b.google_ad_height=c.height;b.google_ad_width=300<d&&300<c.height?c.width:1200<d?1200:Math.round(d);a.style.height=
b.google_ad_height+"px";b.google_ad_resizable=!0;delete b.google_ad_format;b.google_loader_features_used=128}else!Na.test(b.google_ad_width)&&!Q.test(a.style.width)||!Na.test(b.google_ad_height)&&!Q.test(a.style.height)?(c=K(a,c),a.style.width=c.width,a.style.height=c.height,Oa(c,b),b.google_loader_features_used=256):(void 0===window.google_available_width_experiment&&(window.google_available_width_experiment=H(["C","E"],xa)),"E"==window.google_available_width_experiment&&(c=a.style.width,a.style.width=
"100%",b.google_available_width=a.offsetWidth,a.style.width=c),Oa(a.style,b))},sb=function(a){for(var b=document.getElementsByTagName("ins"),c=0,d=b[c];c<b.length;d=b[++c])if(pb(d)&&(!a||d.id==a))return d;return null},tb=function(a){var b=a.element;a=a.params||{};if(b){if(!pb(b)&&(b=b.id&&sb(b.id),!b))throw Error("adsbygoogle: 'element' has already been filled.");if(!("innerHTML"in b))throw Error("adsbygoogle.push(): 'element' is not a good DOM element.");}else if(b=sb(),!b)throw Error("adsbygoogle.push(): All ins elements in the DOM with class=adsbygoogle already have ads in them.");
var c=window;b.setAttribute("data-adsbygoogle-status","done");rb(b,a,c)},ub=function(){if(!window.google_top_experiment&&!window.google_top_js_status){var a=window;if(2!==(a.top==a?0:D(a.top)?1:2))window.google_top_js_status=0;else if(top.postMessage){var b;try{b=E.top.frames.google_top_static_frame?!0:!1}catch(c){b=!1}if(b){if(window.google_top_experiment=H(["jp_c","jp_zl","jp_wfpmr","jp_zlt","jp_wnt"],wa),"jp_c"!==window.google_top_experiment){a=window;a.addEventListener?a.addEventListener("message",
nb,!1):a.attachEvent&&a.attachEvent("onmessage",nb);window.google_top_js_status=3;a={0:"google_loc_request",1:mb};b=[];for(var d in a)b.push(d+"="+a[d]);top.postMessage(b.join("\n"),"*")}}else window.google_top_js_status=2}else window.google_top_js_status=1}if((d=window.adsbygoogle)&&d.shift)for(b=20;(a=d.shift())&&0<b--;)try{tb(a)}catch(f){throw window.setTimeout(ub,0),f;}window.adsbygoogle={push:tb}};ub();})();
