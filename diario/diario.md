## 2020-12-28-102624

Na distribuição Ubuntu 20.04, partes de node são instaladas automaticamente:

<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ apt list --installed | grep npm

WARNING: apt does not have a stable CLI interface. Use with caution in scripts.

node-is-<font color="#DC322F"><b>npm</b></font>/focal,focal,now 1.0.0-1 all [installed,automatic]
node-<font color="#DC322F"><b>npm</b></font>-bundled/focal,focal,now 1.1.1-1 all [installed,automatic]
node-<font color="#DC322F"><b>npm</b></font>-package-arg/focal,focal,now 6.1.1-1 all [installed,automatic]
node-<font color="#DC322F"><b>npm</b></font>-run-path/focal,focal,now 2.0.2-2 all [installed,automatic]
node-<font color="#DC322F"><b>npm</b></font>log/focal,focal,now 4.1.2-2 all [installed,automatic]
node-validate-<font color="#DC322F"><b>npm</b></font>-package-license/focal,focal,now 3.0.4-1 all [installed,automatic]
node-validate-<font color="#DC322F"><b>npm</b></font>-package-name/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>npm</b></font>/focal,focal,now 6.14.4+ds-1ubuntu2 all [installed]
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 

</pre>

Uma seção sobre node, npm e javascript pode ser conveniente.

### Referências

https://pt.wikipedia.org/wiki/Node.js
https://en.wikipedia.org/wiki/Node.js
https://www.w3schools.com/whatis/whatis_npm.asp
https://nodejs.org/en/knowledge/getting-started/npm/what-is-npm/
https://en.wikipedia.org/wiki/Npm_(software)
https://www.businessinsider.com/npm-ceo-bryan-bogensberger-resigns-2019-9
https://www.npmjs.com/policies/conduct#acceptable-package-content
https://www.digitalocean.com/community/tutorials/how-to-install-node-js-on-ubuntu-20-04-pt
https://www.google.com/search?channel=fs&client=ubuntu&q=ubuntu+check+installed+packages
https://askubuntu.com/questions/17823/how-to-list-all-installed-packages


<pre><font color="#859900"><b>abio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ apt list --installed | grep node

WARNING: apt does not have a stable CLI interface. Use with caution in scripts.

lib<font color="#DC322F"><b>node</b></font>-dev/focal,now 10.19.0~dfsg-3ubuntu1 amd64 [installed,automatic]
lib<font color="#DC322F"><b>node</b></font>64/focal,now 10.19.0~dfsg-3ubuntu1 amd64 [installed,automatic]
<font color="#DC322F"><b>node</b></font>-abbrev/focal,focal,now 1.1.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ajv/focal,focal,now 6.10.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ansi-align/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ansi-regex/focal,focal,now 5.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ansi-styles/focal,focal,now 4.2.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ansi/focal,focal,now 0.3.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ansistyles/focal,focal,now 0.1.3-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-anymatch/focal,focal,now 3.1.1+~2.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-aproba/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-archy/focal,focal,now 1.0.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-are-we-there-yet/focal,focal,now 1.1.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-arr-flatten/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-array-differ/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-array-uniq/focal,focal,now 1.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-asap/focal,focal,now 2.0.6-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-asn1/focal,focal,now 0.2.3-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-assert-plus/focal,focal,now 1.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-assert/focal,focal,now 1.4.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-async-each/focal,focal,now 1.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-asynckit/focal,focal,now 0.4.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-aws-sign2/focal,focal,now 0.7.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-aws4/focal,focal,now 1.9.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-balanced-match/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-bcrypt-pbkdf/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-beeper/focal,focal,now 2.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-binary-extensions/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-bl/focal,focal,now 4.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-bluebird/focal,focal,now 3.5.1+dfsg2-2build1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-boxen/focal,focal,now 4.2.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-brace-expansion/focal,focal,now 1.1.11-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-braces/focal,focal,now 3.0.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-builtin-modules/focal,focal,now 3.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-builtins/focal,focal,now 1.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-cacache/focal,focal,now 11.3.3-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-call-limit/focal,focal,now 1.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-camelcase/focal,focal,now 5.3.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-caseless/focal,focal,now 0.12.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-chalk/focal,focal,now 2.4.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-chokidar/focal,focal,now 3.3.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-chownr/focal,focal,now 1.1.3-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ci-info/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-cli-boxes/focal,focal,now 2.2.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-cliui/focal,focal,now 4.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-clone-buffer/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-clone-stats/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-clone/focal,focal,now 2.1.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-cloneable-readable/focal,focal,now 2.0.1-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-co/focal,focal,now 4.6.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-color-convert/focal,focal,now 1.9.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-color-name/focal,focal,now 1.1.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-colors/focal,focal,now 1.4.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-columnify/focal,focal,now 1.5.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-combined-stream/focal,focal,now 1.0.8-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-concat-map/focal,focal,now 0.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-concat-stream/focal,focal,now 1.6.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-config-chain/focal,focal,now 1.1.12-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-configstore/focal,focal,now 5.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-console-control-strings/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-convert-source-map/focal,focal,now 1.6.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-copy-concurrently/focal,focal,now 1.0.5-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-core-util-is/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-cross-spawn/focal,focal,now 5.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-crypto-random-string/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-cyclist/focal,focal,now 1.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-d/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-dashdash/focal,focal,now 1.14.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-dateformat/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-debug/focal,focal,now 4.1.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-decamelize/focal,focal,now 1.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-decompress-response/focal,focal,now 3.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-deep-extend/focal,focal,now 0.6.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-defaults/focal,focal,now 1.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-define-properties/focal,focal,now 1.1.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-delayed-stream/focal,focal,now 1.0.0-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-delegates/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-deprecated/focal,focal,now 0.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-detect-file/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-detect-indent/focal,focal,now 5.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-detect-newline/focal,focal,now 2.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-dot-prop/focal,focal,now 5.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-duplexer3/focal,focal,now 0.1.4-5 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-duplexify/focal,focal,now 4.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ecc-jsbn/focal,focal,now 0.2.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-editor/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-encoding/focal,focal,now 0.1.12-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-end-of-stream/focal,focal,now 1.4.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-err-code/focal,focal,now 2.0.0+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-errno/focal,focal,now 0.1.7-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-error-ex/focal,focal,now 1.3.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-es5-ext/focal,focal,now 0.10.30-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-es6-iterator/focal,focal,now 2.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-es6-promise/focal,focal,now 4.2.8-6 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-es6-symbol/focal,focal,now 3.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-es6-weak-map/focal,focal,now 2.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-escape-string-regexp/focal,focal,now 1.0.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-esutils/focal,focal,now 2.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-execa/focal,focal,now 0.10.0+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-expand-tilde/focal,focal,now 2.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-extend-shallow/focal,focal,now 3.0.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-extend/focal,focal,now 3.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-extsprintf/focal,focal,now 1.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fancy-log/focal,focal,now 1.3.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fast-deep-equal/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fill-range/focal,focal,now 7.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-find-up/focal,focal,now 4.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-findup-sync/focal,focal,now 4.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fined/focal,focal,now 1.0.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-flagged-respawn/focal,focal,now 1.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-flush-write-stream/focal,focal,now 2.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-for-in/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-for-own/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-forever-agent/focal,focal,now 0.6.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-form-data/focal,focal,now 3.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-from2/focal,focal,now 2.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fs-exists-sync/focal,focal,now 0.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fs-vacuum/focal,focal,now 1.2.10-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fs-write-stream-atomic/focal,focal,now 1.0.10-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-fs.realpath/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-function-bind/focal,focal,now 1.1.1+repack-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-gauge/focal,focal,now 2.7.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-genfun/focal,focal,now 5.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-get-caller-file/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-get-stream/focal,focal,now 4.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-get-value/focal,focal,now 1:3.0.1-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-getpass/focal,focal,now 0.1.7-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-glob-parent/focal,focal,now 3.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-glob-stream/focal,focal,now 6.1.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-glob/focal,focal,now 7.1.6-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-global-modules/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-global-prefix/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-globule/focal,focal,now 1.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-glogg/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-got/focal,focal,now 7.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-graceful-fs/focal,focal,now 4.2.3-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-gulp-util/focal,focal,now 3.0.8-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-gulplog/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-gyp/focal,focal,now 6.1.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-har-schema/focal,focal,now 2.0.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-har-validator/focal,focal,now 5.1.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-has-flag/focal,focal,now 4.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-has-gulplog/focal,focal,now 0.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-has-symbol-support-x/focal,focal,now 1.4.1+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-has-to-string-tag-x/focal,focal,now 1.4.1+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-has-unicode/focal,focal,now 2.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-hosted-git-info/focal,focal,now 2.8.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-http-signature/focal,focal,now 1.3.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-iconv-lite/focal,focal,now 0.4.23-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-iferr/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-import-lazy/focal,focal,now 3.0.0.REALLY.2.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-imurmurhash/focal,focal,now 0.1.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-inflight/focal,focal,now 1.0.6-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-inherits/focal,focal,now 2.0.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ini/focal,focal,now 1.3.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-interpret/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-invert-kv/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ip-regex/focal,focal,now 4.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ip/focal,focal,now 1.1.5-5 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-arrayish/focal,focal,now 0.3.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-binary-path/focal,focal,now 2.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-buffer/focal,focal,now 1.1.6-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-extendable/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-extglob/focal,focal,now 2.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-glob/focal,focal,now 4.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-negated-glob/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-npm/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-number/focal,focal,now 7.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-obj/focal,focal,now 1.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-object/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-path-inside/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-plain-obj/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-plain-object/focal,focal,now 2.0.4+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-retry-allowed/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-stream/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-typedarray/focal,focal,now 1.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-unc-path/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-valid-glob/focal,focal,now 1.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-is-windows/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-isarray/focal,focal,now 2.0.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-isexe/focal,focal,now 2.0.0-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-isobject/focal,focal,now 3.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-isstream/focal,focal,now 0.1.2+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-isurl/focal,focal,now 4.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-js-tokens/focal,focal,now 5.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-jsbn/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-json-parse-better-errors/focal,focal,now 1.0.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-json-schema-traverse/focal,focal,now 0.3.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-json-schema/focal,focal,now 0.2.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-json-stable-stringify/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-json-stringify-safe/focal,focal,now 5.0.1+repack-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-jsonify/focal,focal,now 0.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-jsonparse/focal,focal,now 1.3.1-7 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-jsonstream/focal,focal,now 1.3.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-jsprim/focal,focal,now 1.4.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-kind-of/focal,focal,now 6.0.3+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-latest-version/focal,focal,now 3.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lazy-property/focal,focal,now 1.0.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lazystream/focal,focal,now 1.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lcid/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-libnpx/focal,focal,now 10.2.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-liftoff/focal,focal,now 3.1.0-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-locate-path/focal,focal,now 5.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lockfile/focal,focal,now 1.0.4-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lodash-packages/focal,focal,now 4.17.15+dfsg-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lodash-reescape/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lodash-reevaluate/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lodash/focal,focal,now 4.17.15+dfsg-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lowercase-keys/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-lru-cache/focal,focal,now 5.1.1-5 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-make-dir/focal,focal,now 3.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-map-cache/focal,focal,now 0.2.2-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mem/focal,focal,now 1.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-micromatch/focal,focal,now 4.0.2+repack-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mime-types/focal,focal,now 2.1.25-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mime/focal,focal,now 2.4.4+dfsg-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mimic-fn/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mimic-response/focal,focal,now 2.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-minimatch/focal,focal,now 3.0.4-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-minimist/focal,focal,now 1.2.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mississippi/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mkdirp/focal,focal,now 0.5.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-move-concurrently/focal,focal,now 1.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ms/focal,focal,now 2.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-multipipe/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-mute-stream/focal,focal,now 0.0.8-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-nopt/focal,focal,now 3.0.6-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-normalize-package-data/focal,focal,now 2.5.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-normalize-path/focal,focal,now 3.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-npm-bundled/focal,focal,now 1.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-npm-package-arg/focal,focal,now 6.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-npm-run-path/focal,focal,now 2.0.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-npmlog/focal,focal,now 4.1.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-number-is-nan/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-oauth-sign/focal,focal,now 0.9.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-object-assign/focal,focal,now 4.1.1-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-once/focal,focal,now 1.4.0-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-opener/focal,focal,now 1.5.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-orchestrator/focal,focal,now 0.3.8-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ordered-read-streams/focal,focal,now 1.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-os-locale/focal,focal,now 4.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-os-tmpdir/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-osenv/focal,focal,now 0.1.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-p-cancelable/focal,focal,now 0.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-p-finally/focal,focal,now 1.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-p-is-promise/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-p-limit/focal,focal,now 2.2.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-p-locate/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-p-timeout/focal,focal,now 1.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-package-json/focal,focal,now 4.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-parallel-transform/focal,focal,now 1.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-parse-filepath/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-parse-json/focal,focal,now 5.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-path-dirname/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-path-exists/focal,focal,now 4.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-path-is-absolute/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-path-is-inside/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-path-root-regex/focal,focal,now 0.1.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-path-root/focal,focal,now 0.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-performance-now/focal,focal,now 2.1.0+debian-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pify/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pinkie-promise/focal,focal,now 2.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pinkie/focal,focal,now 2.0.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-prepend-http/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pretty-hrtime/focal,focal,now 1.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-process-nextick-args/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-promise-inflight/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-promise-retry/focal,focal,now 1.1.1-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-promzard/focal,focal,now 0.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-proto-list/focal,focal,now 1.2.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-prr/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pseudomap/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-psl/focal,focal,now 1.7.0+ds-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pump/focal,focal,now 3.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-pumpify/focal,focal,now 2.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-punycode/focal,focal,now 2.1.1-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-qs/focal,focal,now 6.9.1+ds-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-qw/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-rc/focal,focal,now 1.2.8-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-read-package-json/focal,focal,now 2.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-read/focal,focal,now 1.0.7-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-readable-stream/focal,focal,now 3.4.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-readdirp/focal,focal,now 3.3.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-rechoir/focal,focal,now 0.6.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-registry-auth-token/focal,focal,now 3.3.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-registry-url/focal,focal,now 3.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-remove-trailing-separator/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-repeat-string/focal,focal,now 1.6.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-replace-ext/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-request/focal,focal,now 2.88.1-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-require-directory/focal,focal,now 2.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-require-main-filename/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-resolve-dir/focal,focal,now 1.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-resolve-from/focal,focal,now 4.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-resolve/focal,focal,now 1.15.1-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-retry/focal,focal,now 0.12.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-rimraf/focal,focal,now 2.6.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-run-queue/focal,focal,now 1.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-safe-buffer/focal,focal,now 5.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-semver-diff/focal,focal,now 2.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-semver/focal,focal,now 7.1.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-sequencify/focal,focal,now 0.0.7-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-set-blocking/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-set-immediate-shim/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-sha/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-shebang-command/focal,focal,now 1.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-shebang-regex/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-signal-exit/focal,focal,now 3.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-slash/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-slide/focal,focal,now 1.1.6-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-sorted-object/focal,focal,now 2.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-sparkles/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-spdx-correct/focal,focal,now 3.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-spdx-exceptions/focal,focal,now 2.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-spdx-expression-parse/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-spdx-license-ids/focal,focal,now 3.0.5-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-sshpk/focal,focal,now 1.16.1+dfsg-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-ssri/focal,focal,now 7.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-stream-consume/focal,focal,now 0.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-stream-each/focal,focal,now 1.2.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-stream-iterate/focal,focal,now 1.2.0-4 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-stream-shift/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-strict-uri-encode/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-string-decoder/focal,focal,now 1.2.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-string-width/focal,focal,now 2.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-strip-ansi/focal,focal,now 6.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-strip-eof/focal,focal,now 1.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-strip-json-comments/focal,focal,now 3.0.1-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-supports-color/focal,focal,now 6.1.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-tar/focal,focal,now 4.4.10+ds1-2ubuntu1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-term-size/focal,focal,now 1.2.0+dfsg-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-text-table/focal,focal,now 0.2.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-through2-filter/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-through2/focal,focal,now 3.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-through/focal,focal,now 2.3.8-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-tildify/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-time-stamp/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-timed-out/focal,focal,now 4.0.1-5 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-to-absolute-glob/focal,focal,now 2.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-to-regex-range/focal,focal,now 5.0.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-tough-cookie/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-tunnel-agent/focal,focal,now 0.6.1-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-tweetnacl/focal,focal,now 1.0.1+dfsg-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-typedarray-to-buffer/focal,focal,now 3.0.3-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-typedarray/focal,focal,now 0.0.6-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-uid-number/focal,focal,now 0.0.6-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-unc-path-regex/focal,focal,now 0.1.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-unique-filename/focal,focal,now 1.1.1+ds-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-unique-stream/focal,focal,now 2.2.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-unique-string/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-unpipe/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-uri-js/focal,focal,now 4.2.2+dfsg-5 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-url-parse-lax/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-url-to-options/focal,focal,now 1.0.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-util-deprecate/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-util/focal,focal,now 0.10.3-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-uuid/focal,focal,now 3.3.2-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-v8flags/focal,focal,now 3.1.2-3 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-validate-npm-package-license/focal,focal,now 3.0.4-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-validate-npm-package-name/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-verror/focal,focal,now 1.10.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-vinyl-fs/focal,focal,now 3.0.3-5 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-vinyl/focal,focal,now 2.2.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-wcwidth.js/focal,focal,now 1.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-which-module/focal,focal,now 2.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-which/focal,focal,now 2.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-wide-align/focal,focal,now 1.1.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-widest-line/focal,focal,now 3.1.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-wrap-ansi/focal,focal,now 4.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-wrappy/focal,focal,now 1.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-write-file-atomic/focal,focal,now 3.0.3-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-xdg-basedir/focal,focal,now 3.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-xtend/focal,focal,now 4.0.2-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-y18n/focal,focal,now 4.0.0-2 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-yallist/focal,focal,now 4.0.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-yargs-parser/focal,focal,now 18.1.1-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>-yargs/focal,focal,now 15.3.0-1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>js-doc/focal,focal,now 10.19.0~dfsg-3ubuntu1 all [installed,automatic]
<font color="#DC322F"><b>node</b></font>js/focal,now 10.19.0~dfsg-3ubuntu1 amd64 [installed,automatic]
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~</b></font>$ 

</pre>

## 2020-12-28-120437

Seguindo as instruções para instalar o servidor:

Depois de entender um pouco sobre, Gradle...

### Referências

https://stackoverflow.com/questions/41700798/gradlew-command-not-found
https://spring.io/guides/gs/gradle/
https://spring.io/
https://spring.io/why-spring
https://www.google.com/search?channel=fs&client=ubuntu&q=gradle+o+que+%C3%A9
https://pt.wikipedia.org/wiki/Gradle
https://en.wikipedia.org/wiki/Gradle


### Resultado


<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ ls
build.gradle  <font color="#268BD2"><b>gradle</b></font>  gradlew  gradlew.bat  <font color="#268BD2"><b>src</b></font>
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ ./gradlew
bash: ./gradlew: Permissão negada
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ sh gradlew
Downloading https://services.gradle.org/distributions/gradle-5.2.1-all.zip
..............................................................................................................................

Welcome to Gradle 5.2.1!

Here are the highlights of this release:
 - Define sets of dependencies that work together with Java Platform plugin
 - New C++ plugins with dependency management built-in
 - New C++ project types for gradle init
 - Service injection into plugins and project extensions

For more details see https://docs.gradle.org/5.2.1/release-notes.html

Starting a Gradle Daemon (subsequent builds will be faster)

<b>&gt; Task :help</b>

Welcome to Gradle 5.2.1.

To run a build, run <b>gradlew &lt;task&gt; ...</b>

To see a list of available tasks, run <b>gradlew tasks</b>

To see a list of command-line options, run <b>gradlew --help</b>

To see more detail about a task, run <b>gradlew help --task &lt;task&gt;</b>

For troubleshooting, visit <b>https://help.gradle.org</b>

<font color="#859900"><b>BUILD SUCCESSFUL</b></font> in 1m 17s
1 actionable task: 1 executed
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ 

</pre>

## 2020-12-28-121202

Seguindo instruções para client

### Resultado
<pre><font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/server</b></font>$ cd ..
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot</b></font>$ cd client/
<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/client</b></font>$ npm install

&gt; @fortawesome/fontawesome-common-types@0.2.32 postinstall /home/fabio/Documentos/git/domotic-swot/client/node_modules/@fortawesome/fontawesome-common-types
&gt; node attribution.js

Font Awesome Free 0.2.32 by @fontawesome - https://fontawesome.com
License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License)


&gt; core-js@2.6.11 postinstall /home/fabio/Documentos/git/domotic-swot/client/node_modules/babel-runtime/node_modules/core-js
&gt; node -e &quot;try{require(&apos;./postinstall&apos;)}catch(e){}&quot;

<font color="#93A1A1">Thank you for using core-js (</font><font color="#839496"> https://github.com/zloirock/core-js </font><font color="#93A1A1">) for polyfilling JavaScript standard library!</font>

<font color="#93A1A1">The project needs your help! Please consider supporting of core-js on Open Collective or Patreon: </font>
<font color="#93A1A1">&gt;</font><font color="#839496"> https://opencollective.com/core-js </font>
<font color="#93A1A1">&gt;</font><font color="#839496"> https://www.patreon.com/zloirock </font>

<font color="#93A1A1">Also, the author of core-js (</font><font color="#839496"> https://github.com/zloirock </font><font color="#93A1A1">) is looking for a good job -)</font>


&gt; core-js@3.6.5 postinstall /home/fabio/Documentos/git/domotic-swot/client/node_modules/core-js
&gt; node -e &quot;try{require(&apos;./postinstall&apos;)}catch(e){}&quot;


&gt; core-js-pure@3.6.5 postinstall /home/fabio/Documentos/git/domotic-swot/client/node_modules/core-js-pure
&gt; node -e &quot;try{require(&apos;./postinstall&apos;)}catch(e){}&quot;


&gt; @fortawesome/fontawesome-svg-core@1.2.32 postinstall /home/fabio/Documentos/git/domotic-swot/client/node_modules/@fortawesome/fontawesome-svg-core
&gt; node attribution.js

Font Awesome Free 1.2.32 by @fontawesome - https://fontawesome.com
License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License)


&gt; @fortawesome/free-solid-svg-icons@5.15.1 postinstall /home/fabio/Documentos/git/domotic-swot/client/node_modules/@fortawesome/free-solid-svg-icons
&gt; node attribution.js

Font Awesome Free 5.15.1 by @fontawesome - https://fontawesome.com
License - https://fontawesome.com/license/free (Icons: CC BY 4.0, Fonts: SIL OFL 1.1, Code: MIT License)

<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">optional</font> SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules/webpack-dev-server/node_modules/fsevents):
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">notsup</font> SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {&quot;os&quot;:&quot;darwin&quot;,&quot;arch&quot;:&quot;any&quot;} (current: {&quot;os&quot;:&quot;linux&quot;,&quot;arch&quot;:&quot;x64&quot;})
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">optional</font> SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules/watchpack-chokidar2/node_modules/fsevents):
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">notsup</font> SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {&quot;os&quot;:&quot;darwin&quot;,&quot;arch&quot;:&quot;any&quot;} (current: {&quot;os&quot;:&quot;linux&quot;,&quot;arch&quot;:&quot;x64&quot;})
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">optional</font> SKIPPING OPTIONAL DEPENDENCY: fsevents@1.2.13 (node_modules/jest-haste-map/node_modules/fsevents):
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">notsup</font> SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@1.2.13: wanted {&quot;os&quot;:&quot;darwin&quot;,&quot;arch&quot;:&quot;any&quot;} (current: {&quot;os&quot;:&quot;linux&quot;,&quot;arch&quot;:&quot;x64&quot;})
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">optional</font> SKIPPING OPTIONAL DEPENDENCY: fsevents@2.1.2 (node_modules/fsevents):
<span style="background-color:#073642"><font color="#EEE8D5">npm</font></span> <span style="background-color:#B58900"><font color="#073642">WARN</font></span> <font color="#D33682">notsup</font> SKIPPING OPTIONAL DEPENDENCY: Unsupported platform for fsevents@2.1.2: wanted {&quot;os&quot;:&quot;darwin&quot;,&quot;arch&quot;:&quot;any&quot;} (current: {&quot;os&quot;:&quot;linux&quot;,&quot;arch&quot;:&quot;x64&quot;})

added 1627 packages from 808 contributors and audited 1631 packages in 29.852s

59 packages are looking for funding
  run `npm fund` for details

found <font color="#CB4B16">4986</font> vulnerabilities (4983 <b>low</b>, 3 <font color="#CB4B16">high</font>)
  run `npm audit fix` to fix them, or `npm audit` for details


<font color="#B58900">   ╭─────────────────────────────────────────────────────────────────╮</font>
   <font color="#B58900">│</font>                                                                 <font color="#B58900">│</font>
   <font color="#B58900">│</font>      New <font color="#859900">patch</font> version of npm available! <font color="#DC322F">6.14.4</font> → <font color="#859900">6.14.10</font>       <font color="#B58900">│</font>
   <font color="#B58900">│</font>   <font color="#B58900">Changelog:</font> <font color="#2AA198">https://github.com/npm/cli/releases/tag/v6.14.10</font>   <font color="#B58900">│</font>
   <font color="#B58900">│</font>                Run <font color="#859900">npm install -g npm</font> to update!                <font color="#B58900">│</font>
   <font color="#B58900">│</font>                                                                 <font color="#B58900">│</font>
<font color="#B58900">   ╰─────────────────────────────────────────────────────────────────╯</font>

<font color="#859900"><b>fabio@fabio-13Z940-G-BK71P1</b></font>:<font color="#268BD2"><b>~/Documentos/git/domotic-swot/client</b></font>$ 

</pre>

