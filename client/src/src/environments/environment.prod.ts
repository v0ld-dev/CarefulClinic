export const environment = {
  production: false,
  BACKEND_URL: window.location.protocol + '//' + window.location.hostname + ':' + 8080,
  path_informing: '/content/report/informing',
  path_downloads: '/content/donwload',
  path_uploads: '/content/upload',
 title:'\u041A\u0430\u0440\u0442\u043E\u0447\u043A\u0430',
 tab1:'\u0414\u0430\u043D\u043D\u044B\u0435 \u0420\u0421 \u0415\u0420\u0417',
 tab2:'\u0414\u0430\u043D\u043D\u044B\u0435 \u0410\u0418\u0421 \u0413\u042D\u0420',
 tab3:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
 surname : '\u0424\u0430\u043C\u0438\u043B\u0438\u044F',
 firstname : '\u0418\u043C\u044F',
 lastname : '\u041E\u0442\u0447\u0435\u0441\u0442\u0432\u043E',
 bithday : '\u0414\u0430\u0442\u0430 \u0440\u043E\u0436\u0434\u0435\u043D\u0438\u044F',
 telefon : '\u0422\u0435\u043B\u0435\u0444\u043E\u043D',
 t_years : '\u041F\u043E\u043B\u043D\u044B\u0445 \u043B\u0435\u0442',
 start_date_etap1 : '\u0414\u0430\u0442\u0430 \u043D\u0430\u0447\u0430\u043B\u0430 \u043F\u0435\u0440\u0432\u043E\u0433\u043E \u044D\u0442\u0430\u043F\u0430',
 end_date_etap1 : '\u0414\u0430\u0442\u0430 \u043E\u043A\u043E\u043D\u0447\u0430\u043D\u0438\u044F \u043F\u0435\u0440\u0432\u043E\u0433\u043E \u044D\u0442\u0430\u043F\u0430',
 start_date_etap2 : '\u0414\u0430\u0442\u0430 \u043D\u0430\u0447\u0430\u043B\u0430 \u0432\u0442\u043E\u0440\u043E\u0433\u043E \u044D\u0442\u0430\u043F\u0430',
 end_date_etap2 : '\u0414\u0430\u0442\u0430 \u043E\u043A\u043E\u043D\u0447\u0430\u043D\u0438\u044F \u0432\u0442\u043E\u0440\u043E\u0433\u043E \u044D\u0442\u0430\u043F\u0430',
 ref_id_person : '\u0418\u0414 \u043F\u0430\u0446\u0438\u0435\u043D\u0442\u0430 \u0432 \u0418\u0421 \u0413\u042D\u0420',
 pm_god : '\u0413\u043E\u0434 \u043F\u0440\u043E\u0445\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u0434\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u0438',
 pm_kvartal : '\u041A\u0432\u0430\u0440\u0442\u0430\u043B \u043F\u0440\u043E\u0445\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u0434\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u0438',
 PM_HOSPITAL_RESULT : '\u041A\u043E\u0434 \u041B\u041F\u0423',
 adress : '\u0410\u0434\u0440\u0435\u0441 \u043F\u0430\u0446\u0438\u0435\u043D\u0442\u0430',
 tel : '\u0422\u0435\u043B\u0435\u0444\u043E\u043D \u043F\u0430\u0446\u0438\u0435\u043D\u0442\u0430',
 pm_result : '\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442 \u043F\u0440\u043E\u0445\u043E\u0436\u0434\u0435\u043D\u0438\u044F',
 close_card : '\u0417\u0430\u043A\u0440\u044B\u0442\u044C',
 nstage : '\u042D\u0442\u0430\u043F \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
 dinfo : '\u0414\u0430\u0442\u0430 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
 tinfo : '\u0412\u0438\u0434 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
 data_not_found: '\u0414\u0430\u043D\u043D\u044B\u0435 \u043D\u0435 \u043D\u0430\u0439\u0434\u0435\u043D\u044B',
 lists_insur: '\u0421\u043F\u0438\u0441\u043A\u0438 \u0437\u0430\u0441\u0442\u0440\u0430\u0445\u043E\u0432\u0430\u043D\u043D\u044B\u0445 \u043B\u0438\u0446',
 search_table: '\u041F\u043E\u0438\u0441\u043A \u043F\u043E \u0442\u0430\u0431\u043B\u0438\u0446\u0435',
 list_insur_menu: ' \u0421\u043F\u0438\u0441\u043A\u0438 \u0437\u0430\u0441\u0442\u0440\u0430\u0445\u043E\u0432\u0430\u043D\u043D\u044B\u0445',
 serch_form:'\u041F\u043E\u0438\u0441\u043A',
 field_is_required:'\u043F\u043E\u043B\u0435 \u043E\u0431\u044F\u0437\u0430\u0442\u0435\u043B\u044C\u043D\u043E \u0434\u043B\u044F \u0437\u0430\u043F\u043E\u043B\u043D\u0435\u043D\u0438\u044F',
 reset:'\u0441\u0431\u0440\u043E\u0441\u0438\u0442\u044C',
 cancel:'\u043E\u0442\u043C\u0435\u043D\u0438\u0442\u044C',
 action_add_person: '\u0417\u0430\u0441\u0442\u0440\u0430\u0445\u043E\u0432\u0430\u043D\u043D\u043E\u0435 \u043B\u0438\u0446\u043E \u043D\u0430\u0439\u0434\u0435\u043D\u043E \u0432 \u0420\u0421 \u0415\u0420\u0417',
 add_table: '\u0414\u043E\u0431\u0430\u0432\u043B\u0435\u043D \u0432 \u0441\u043F\u0438\u0441\u043E\u043A',
bad_action_add_person : '\u0414\u0430\u043D\u043D\u044B\u0435 \u043D\u0435 \u043D\u0430\u0439\u0434\u0435\u043D\u044B \u0432 \u0420\u0421 \u0415\u0420\u0417 \u0438\u043B\u0438 \u0417\u041B \u043D\u0435 \u044F\u0432\u043B\u044F\u0435\u0442\u0441\u044F \u0432\u0430\u0448\u0438\u043C \u043A\u043B\u0438\u0435\u043D\u0442\u043E\u043C',
no_inform:'\u043D\u0435 \u043F\u0440\u043E\u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D',
one_part_inform:'\u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D \u043E \u043F\u0435\u0440\u0432\u043E\u043C \u044D\u0442\u0430\u043F\u0435',
second_part_inform:'\u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D \u043E \u0432\u0442\u043E\u0440\u043E\u043C \u044D\u0442\u0430\u043F\u0435',
secondory_inform:'\u043F\u043E\u0432\u0442\u043E\u0440\u043D\u043E\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
tinfo_1: 'sms',
tinfo_2: '\u0422\u0435\u043B\u0435\u0444\u043E\u043D',
tinfo_3: '\u042D\u043B\u0435\u043A\u0442\u0440\u043E\u043D\u043D\u0430\u044F \u043F\u043E\u0447\u0442\u0430',
tinfo_4: '\u0421\u0440\u0435\u0434\u0441\u0442\u0432\u0430\u043C\u0438 \u043F\u043E\u0447\u0442\u043E\u0432\u043E\u0439 \u0441\u0432\u044F\u0437\u0438',
tinfo_5: '\u041B\u0438\u0447\u043D\u043E\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
tinfo_6: '\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u043D\u0435\u0432\u043E\u0437\u043C\u043E\u0436\u043D\u043E',
tinfo_7: '\u0414\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u044F \u043F\u0440\u043E\u0432\u0435\u0434\u0435\u043D\u0430',
linksmo: '\u0421\u0442\u0440\u0430\u0445\u043E\u0432\u0430\u044F \u043A\u043E\u043C\u043F\u0430\u043D\u0438\u044F',
linksmo_2: '\u041E\u041E\u041E \u0412\u0422\u0411 \u041C\u0421 ',
linksmo_1: '\u041E\u041E\u041E \u00AB\u0421\u0418\u041C\u0410\u0417-\u041C\u0415\u0414\u00BB',
linksmo_4: '\u0421\u041A \u00AB\u0418\u043D\u0433\u043E\u0441\u0441\u0442\u0440\u0430\u0445-\u041C\u00BB',
otkreplen: '\u043E\u0442\u043A\u0440\u0435\u043F\u043B\u0435\u043D',
exit_app:'\u0412\u044B\u0439\u0442\u0438 \u0438\u0437 \u043F\u0440\u0438\u043B\u043E\u0436\u0435\u043D\u0438\u044F',
searchFIOD:'\u041F\u043E\u0438\u0441\u043A \u043F\u043E \u0424\u0418\u041E\u0414',
searchKEYS:'\u041F\u043E\u0438\u0441\u043A \u043F\u043E \u0443\u0441\u043B\u043E\u0432\u0438\u044E',
exportExcel:'\u042D\u043A\u0441\u043F\u043E\u0440\u0442 \u0432 MS Excel',
age:'\u0412\u043E\u0437\u0440\u0430\u0441\u0442',
sexmans:'\u041C\u0443\u0436\u0441\u043A\u043E\u0439',
sexmale:'\u0416\u0435\u043D\u0441\u043A\u0438\u0439',
ex:'\u041E\u0442',
through:'\u0414\u043E',
mo:'\u041C\u0435\u0434\u0438\u0446\u0438\u043D\u0441\u043A\u0430\u044F \u043E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u044F',
motype:'\u0422\u0438\u043F \u041C\u041E',
withtel:'\u0421 \u0442\u0435\u043B\u0435\u0444\u043E\u043D\u0430\u043C\u0438 (\u0420\u0421 \u0415\u0420\u0417)',
inform:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
I:'I \u044D\u0442\u0430\u043F',
II:'II \u044D\u0442\u0430\u043F',
III:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u0442\u044C \u043F\u043E\u0432\u0442\u043E\u0440\u043D\u043E',
sms:'\u0441\u043C\u0441  ',
telsearchkeys:'\u0442\u0435\u043B\u0435\u0444\u043E\u043D',
email:'\u044D\u043B. \u043F\u043E\u0447\u0442\u0430',
mail:'\u043F\u043E\u0447\u0442\u0430',
personaly:'\u043B\u0438\u0447\u043D\u043E',
notfound:'\u043D\u0435\u0432\u043E\u0437\u043C\u043E\u0436\u043D\u043E',
doneexamination:'\u041F\u0440\u043E\u0448\u0435\u043B \u0434\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u044E',
periodinf:'\u041F\u0435\u0440\u0438\u043E\u0434 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
dispanser:'\u0414\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u044F \u043F\u043E \u0434\u0430\u043D\u043D\u044B\u043C \u0438\u0437 "\u0413\u042D\u0420"',
statedisp:'\u0432\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0441\u0442\u0430\u0442\u0443\u0441',
causenotes:'\u043E\u0433\u0440\u0430\u043D\u0438\u0447\u0435\u043D\u0438\u0435 \u0432\u044B\u0431\u043E\u0440\u043A\u0438',
cleartable:'\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C \u0442\u0430\u0431\u043B\u0438\u0446\u0443',
survey:'\u041E\u043F\u0440\u043E\u0441',
downloadtask:'\u0421\u043A\u0430\u0447\u0430\u0442\u044C',
statsurvey1:'\u041D\u0435 \u043F\u043E\u0434\u0445\u043E\u0434\u0438\u0442 \u0433\u0440\u0430\u0444\u0438\u043A \u0440\u0430\u0431\u043E\u0442\u044B \u041C\u041E \u0434\u043B\u044F \u043F\u0440\u043E\u0432\u0435\u0434\u0435\u043D\u0438\u044F \u041F\u041C (\u0432 \u0442.\u0447. \u041C\u041E \u043D\u0435 \u0440\u0430\u0431\u043E\u0442\u0430\u0435\u0442 \u0432 \u0432\u044B\u0445\u043E\u0434\u043D\u044B\u0435 \u0434\u043D\u0438)',
statsurvey2:'\u041E\u0442\u0434\u0430\u043B\u0435\u043D\u043D\u043E\u0441\u0442\u044C \u041C\u041E \u043E\u0442 \u043C\u0435\u0441\u0442\u0430 \u043F\u0440\u043E\u0436\u0438\u0432\u0430\u043D\u0438\u044F',
statsurvey3:'\u0414\u043B\u0438\u0442\u0435\u043B\u044C\u043D\u044B\u0439 \u0441\u0440\u043E\u043A \u043F\u0440\u043E\u0445\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u041F\u041C',
statsurvey4:'\u041D\u0435\u0443\u0434\u043E\u0432\u043B\u0435\u0442\u0432\u043E\u0440\u0435\u043D\u043D\u043E\u0441\u0442\u044C \u043A\u0430\u0447\u0435\u0441\u0442\u0432\u043E\u043C \u0443\u0441\u043B\u0443\u0433 \u0432 \u041C\u041E',
statsurvey5:'\u041D\u0435\u0442 \u0441\u0432\u043E\u0431\u043E\u0434\u043D\u043E\u0433\u043E \u0432\u0440\u0435\u043C\u0435\u043D\u0438',
statsurvey6:'\u0420\u0430\u0431\u043E\u0442\u043E\u0434\u0430\u0442\u0435\u043B\u044C \u043D\u0435 \u043E\u0442\u043F\u0443\u0441\u043A\u0430\u0435\u0442',
statsurvey7:'\u041D\u0435 \u0437\u043D\u0430\u043B',
statsurvey8:'\u041D\u0435 \u0445\u043E\u0447\u0443',
statsurvey9:'\u041F\u0440\u043E\u0439\u0434\u0443 \u043F\u043E\u0437\u0436\u0435',
statsurvey10:'\u0414\u0440\u0443\u0433\u043E\u0435',
statsurvey_result:'\u0420\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442 \u043E\u043F\u0440\u043E\u0441\u0430',
statsurvey_date:'\u0414\u0430\u0442\u0430 \u043E\u043F\u0440\u043E\u0441\u0430',
titlesurvey:'\u041E\u0433\u043B\u0430\u0432\u043B\u0435\u043D\u0438\u0435',
maintitlesurvey:'\u0412\u043D\u0435\u0441\u0442\u0438 \u0440\u0435\u0437\u0443\u043B\u044C\u0442\u0430\u0442 \u043E\u043F\u0440\u043E\u0441\u0430',
nonrespond:'\u041D\u0435 \u043E\u043F\u0440\u043E\u0448\u0435\u043D',
respond:'\u041E\u043F\u0440\u043E\u0448\u0435\u043D',
survey_stat:'\u0440\u0435\u043B\u0443\u043B\u044C\u0442\u0430\u0442',
kv1:'\u0432 \u043F\u043B\u0430\u043D\u0435 I-\u0433\u043E \u043A\u0432\u0430\u0440\u0442\u0430\u043B\u0430',
kv2:'\u0432 \u043F\u043B\u0430\u043D\u0435 II-\u0433\u043E \u043A\u0432\u0430\u0440\u0442\u0430\u043B\u0430',
kv3:'\u0432 \u043F\u043B\u0430\u043D\u0435 III-\u0433\u043E \u043A\u0432\u0430\u0440\u0442\u0430\u043B\u0430',
kv4:'\u0432 \u043F\u043B\u0430\u043D\u0435 IV-\u0433\u043E \u043A\u0432\u0430\u0440\u0442\u0430\u043B\u0430',
plandisp:'\u041F\u043B\u0430\u043D \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
infoI:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u0442\u044C \u043E I-\u043C \u044D\u0442\u0430\u043F\u0435',
infoII:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u0442\u044C \u043E II-\u043C \u044D\u0442\u0430\u043F\u0435',
infoIII:'\u041F\u043E\u0432\u0442\u043E\u0440\u043D\u043E\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
uploadfile:'\u0417\u0430\u0433\u0440\u0443\u0437\u0438\u0442\u044C \u0434\u0430\u043D\u043D\u044B\u0435',
pull:'\u041F\u0443\u043B \u0437\u0430\u0433\u0440\u0443\u0436\u0435\u043D\u043D\u044B\u0445 \u0434\u0430\u043D\u043D\u044B\u0445 \u0438 \u043F\u0440\u043E\u0442\u043E\u043A\u043E\u043B\u043E\u0432 \u0437\u0430\u0433\u0440\u0443\u0437\u043A\u0438',
drop:'\u041F\u0435\u0440\u0435\u043C\u0435\u0441\u0442\u0438\u0442\u0435 \u0441\u044E\u0434\u0430 \u0444\u0430\u0439\u043B',
list_inform_header:'\u0421\u043F\u0438\u0441\u043A\u0438 \u0434\u043B\u044F \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
menu_main_page:'\u0413\u043B\u0430\u0432\u043D\u0430\u044F \u0441\u0442\u0440\u0430\u043D\u0438\u0446\u0430',
menu_report_page:'\u041E\u0442\u0447\u0435\u0442\u044B',
report_inform:'\u041F\u0435\u0440\u0432\u0438\u0447\u043D\u043E\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
report_inform_note:'\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0442\u0438\u043F \u043E\u0442\u0447\u0435\u0442\u0430',
report_inform_plane:'\u041F\u043B\u0430\u043D \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F \u0437\u0430 \u0432\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0439 \u043A\u0432\u0430\u0440\u0442\u0430\u043B',
report_inform_btn_download:'\u0421\u043A\u0430\u0447\u0430\u0442\u044C',
report_inform_all:'\u041F\u043E\u0434\u043B\u0435\u0436\u0430\u0449\u0438\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044E \u0437\u0430 \u0442\u0435\u043A\u0443\u0449\u0438\u0439 \u0433\u043E\u0434 (\u043F.211 \u043F\u0440\u0430\u0432\u0438\u043B)',
report_inform_note_after:'\u0412\u044B\u0431\u0440\u0430\u043D\u043D\u044B\u0439 \u043E\u0442\u0447\u0435\u0442',
report_inform_select_kv:'\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u043A\u0432\u0430\u0440\u0442\u0430\u043B',
report_reinform:'\u041F\u043E\u0432\u0442\u043E\u0440\u043D\u043E\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
menu_admin:'\u0410\u0434\u043C\u0438\u043D\u0438\u0441\u0442\u0440\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435',
menu_admin_inform_allyear:'\u0421\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u0442\u044C \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u0437\u0430 \u0442\u0435\u043A\u0443\u0449\u0438\u0439 \u0433\u043E\u0434 (\u043F.211 \u043F\u0440\u0430\u0432\u0438\u043B)',
admin_inform_mainsubmodul_title:'\u0410\u0434\u043C\u0438\u043D\u0438\u0441\u0442\u0440\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u0431\u043B\u043E\u043A\u0430 \u0434\u0430\u043D\u043D\u044B\u0445 \u043E \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0438',
reestr_inform_all_year_download_file:'\u0420\u0435\u0435\u0441\u0442\u0440 \u043F\u043E\u0434\u043B\u0435\u0436\u0430\u0449\u0438\u0445 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044E  \u043D\u0430 \u0442\u0435\u043A\u0443\u0449\u0438\u0439 \u0433\u043E\u0434',
reestr_file:'\u0424\u0430\u0439\u043B',
reestr_download:'\u0441\u043A\u0430\u0447\u0430\u0442\u044C',
report_inform_about_second_level:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u043E 2-\u043C \u044D\u0442\u0430\u043F\u0435',
year_disp:'\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0433\u043E\u0434 \u043F\u0440\u043E\u0445\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u0434\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u0438:  ',
main_title:'\u0415\u0434\u0438\u043D\u043E\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u043E\u043D\u043D\u043E\u0435 \u043F\u0440\u043E\u0441\u0442\u0440\u0430\u043D\u0441\u0442\u0432\u043E \u041D\u043E\u0432\u043E\u0441\u0438\u0431\u0438\u0440\u0441\u043A\u043E\u0439 \u043E\u0431\u043B\u0430\u0441\u0442\u0438',
title_sp3_exptise:'\u041E\u0442\u0447\u0435\u0442\u044B / \u0421\u0442\u0440\u0430\u0445\u043E\u0432\u043E\u0439 \u043F\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043B\u044C 3 /',
expertise_field1:'\u041A\u043E\u043D\u0442\u0440\u043E\u043B\u044C \u041C\u041A\u0411 \u0432 3\u0430 \u0433\u0440\u0443\u043F\u043F\u0435 \u0437\u0434\u043E\u0440\u043E\u0432\u044C\u044F',
expertise_field2:'\u041A\u043E\u043D\u0442\u0440\u043E\u043B\u044C \u041C\u041A\u0411 \u0432 1 \u0438 3\u0431 \u0433\u0440\u0443\u043F\u043F\u0430\u0445 \u0437\u0434\u043E\u0440\u043E\u0432\u044C\u044F',
a3_3b_other:'\u041A\u043E\u043D\u0442\u0440\u043E\u043B\u044C 3 \u0433\u0440\u0443\u043F\u043F\u044B \u043D\u0430 \u043D\u0430\u0437\u043D\u0430\u0447\u0435\u043D\u0438\u0435 \u043B\u0435\u0447\u0435\u0431\u043D\u043E-\u043F\u0440\u043E\u0444\u0438\u043B\u0430\u043A\u0442\u0438\u0447\u0435\u0441\u043A\u0438\u0445 \u043C\u0435\u0440\u043E\u043F\u0440\u0438\u044F\u0442\u0438\u0439',
list_resolved:'\u0421\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u043D\u044B\u0435 \u043E\u0442\u0447\u0435\u0442\u044B',
expertise_field1_1:'\u0412\u044B\u0431\u0435\u0440\u0438\u0442\u0435 \u0432\u0440\u0435\u043C\u0435\u043D\u043D\u043E\u0439 \u043F\u0435\u0440\u0438\u043E\u0434 \u043F\u043E \u0441\u0447\u0435\u0442\u0430\u043C \u043F\u0440\u043E\u043B\u0435\u0447\u0435\u043D\u043D\u044B\u0445',
sp3_menu:'\u0421\u0442\u0440\u0430\u0445\u043E\u0432\u043E\u0439 \u043F\u0440\u0435\u0434\u0441\u0442\u0430\u0432\u0438\u0442\u0435\u043B\u044C 3',
sp3_menu_expertisa:'\u042D\u043A\u0441\u043F\u0435\u0440\u0442\u0438\u0437\u0430',
profmedosmtr:'\u041F\u0440\u043E\u0444\u0438\u043B\u0430\u043A\u0442\u0438\u0447\u0435\u0441\u043A\u0438\u0435 \u043C\u0435\u0434.\u043E\u0441\u043C\u043E\u0442\u0440\u044B',
statistics_inform_header:'\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043A\u0430 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
title_stat_inform:'\u041E\u0442\u0447\u0435\u0442\u044B / \u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043A\u0430 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F',
report_stat_inform :'\u0421\u0432\u0435\u0434\u0435\u043D\u0438\u044F \u043E\u0431 \u043E\u0440\u0433\u0430\u043D\u0438\u0437\u0430\u0446\u0438\u0438 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F \u0437\u0430\u0441\u0442\u0440\u0430\u0445\u043E\u0432\u0430\u043D\u043D\u044B\u0445 \u043B\u0438\u0446 \u043E \u0432\u043E\u0437\u043C\u043E\u0436\u043D\u043E\u0441\u0442\u0438 \u043F\u0440\u043E\u0445\u043E\u0436\u0434\u0435\u043D\u0438\u044F \u0434\u0438\u0441\u043F\u0430\u043D\u0441\u0435\u0440\u0438\u0437\u0430\u0446\u0438\u0438',
report_inform_plane_actual :'\u0410\u043A\u0442\u0443\u0430\u043B\u044C\u043D\u044B\u0439 \u043F\u043B\u0430\u043D \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F \u0437\u0430 \u043E\u043F\u0440\u0435\u0434\u0435\u043B\u0435\u043D\u043D\u044B\u0439 \u043A\u0432\u0430\u0440\u0442\u0430\u043B',
title_stat_assent :'\u041E\u0442\u0447\u0435\u0442\u044B / \u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043A\u0430 \u0441\u043E\u0433\u043B\u0430\u0441\u0438\u0439',
statistics_assent_header:'\u0421\u0442\u0430\u0442\u0438\u0441\u0442\u0438\u043A\u0430 \u0441\u043E\u0433\u043B\u0430\u0441\u0438\u0439',
assent_field1_1:'\u0412\u0432\u0435\u0434\u0438\u0442\u0435 \u043F\u0435\u0440\u0438\u043E\u0434',
report_stat_assent:'\u0418\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u044F \u043E \u043A\u043E\u043B\u0438\u0447\u0435\u0441\u0442\u0432\u0435 \u0438\u043D\u0444\u043E\u0440\u043C\u0430\u0446\u0438\u043E\u043D\u043D\u044B\u0445 \u0441\u043E\u0433\u043B\u0430\u0441\u0438\u0439',
sp3_menu_d_reestr:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u0417\u041B, \u0441\u0442\u043E\u044F\u0449\u0438\u0445 \u043D\u0430 \u0414-\u0443\u0447\u0435\u0442\u0435',
info_d_reestr:'\u0424\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u0435 \u0441\u043F\u0438\u0441\u043A\u0430 \u0438\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F \u0417\u041B, \u0441\u0442\u043E\u044F\u0449\u0438\u0445 \u043D\u0430 \u0414-\u0443\u0447\u0435\u0442\u0435',
info_d_reestr1:'\u0418\u043D\u0444\u043E\u0440\u043C\u0438\u0440\u043E\u0432\u0430\u043D\u0438\u044F \u0417\u041B, \u0441\u0442\u043E\u044F\u0449\u0438\u0445 \u043D\u0430 \u0414-\u0443\u0447\u0435\u0442\u0435'

};
