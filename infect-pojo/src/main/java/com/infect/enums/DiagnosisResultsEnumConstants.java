package com.infect.enums;

public class DiagnosisResultsEnumConstants {

    // SubmissionUserType 枚举常量
    public static final String SUBMISSION_USER_TYPE_ADMIN = "系统管理员";
    public static final String SUBMISSION_USER_TYPE_RAILWAY_EMPLOYEE = "铁路职工";
    public static final String SUBMISSION_USER_TYPE_CDC_STAFF = "疾控中心工作人员";
    public static final String SUBMISSION_USER_TYPE_MEDICAL_STAFF = "专职医护人员";

    // DiseaseType 枚举常量
    public static final String DISEASE_TYPE_COVID19 = "新型冠状病毒感染";
    public static final String DISEASE_TYPE_FLU = "流感";
    public static final String DISEASE_TYPE_PLAGUE = "鼠疫";
    public static final String DISEASE_TYPE_INFECTIOUS_DIARRHEA = "感染性腹泻";
    public static final String DISEASE_TYPE_ANTHRAX = "炭疽";
    public static final String DISEASE_TYPE_TUBERCULOSIS = "结核病";
    public static final String DISEASE_TYPE_DENGUE = "登革热（蚊媒传染病）";
    public static final String DISEASE_TYPE_MALARIA = "疟疾（蚊媒传染病）";
    public static final String DISEASE_TYPE_FOREST_ENCEPHALITIS = "森林脑炎（蜱媒传染病）";
    public static final String DISEASE_TYPE_FTHS = "发热伴血小板减少综合征（蜱媒传染病）";
    public static final String DISEASE_TYPE_TYPHUS = "斑疹伤寒";
    public static final String DISEASE_TYPE_HEMORRHAGIC_FEVER = "流行性出血热";
    public static final String DISEASE_TYPE_OTHER = "其他";

    // PlagueSubtype 枚举常量
    public static final String PLAGUE_SUBTYPE_BUBONIC = "腺鼠疫";
    public static final String PLAGUE_SUBTYPE_PNEUMONIC = "肺鼠疫";
    public static final String PLAGUE_SUBTYPE_SEPTICEMIC = "败血型鼠疫";
    public static final String PLAGUE_SUBTYPE_INTESTINAL = "肠鼠疫";
    public static final String PLAGUE_SUBTYPE_OCULAR = "眼鼠疫";
    public static final String PLAGUE_SUBTYPE_CUTANEOUS = "皮肤鼠疫";
    public static final String PLAGUE_SUBTYPE_CEREBRAL = "脑鼠疫";

    // AnthraxSubtype 枚举常量
    public static final String ANTHRAX_SUBTYPE_CUTANEOUS = "皮肤炭疽";
    public static final String ANTHRAX_SUBTYPE_INTESTINAL = "肠炭疽";
    public static final String ANTHRAX_SUBTYPE_PULMONARY = "肺炭疽";
    public static final String ANTHRAX_SUBTYPE_MENINGITIS = "脑膜炎型炭疽";
    public static final String ANTHRAX_SUBTYPE_SEPTICEMIA = "败血症型炭疽";

    // DiscoveryMethod 枚举常量
    public static final String DISCOVERY_METHOD_APP_REPORTING = "APP填报";
    public static final String DISCOVERY_METHOD_SELF_REFERRAL = "主动就诊";
    public static final String DISCOVERY_METHOD_ROUTINE_SURVEILLANCE = "常规监测发现";
    public static final String DISCOVERY_METHOD_HEALTH_CHECK = "健康检查";
    public static final String DISCOVERY_METHOD_OTHER = "其他";

    // DiseaseOutcome 枚举常量
    public static final String DISEASE_OUTCOME_CURED = "治愈";
    public static final String DISEASE_OUTCOME_IMPROVED = "好转";
    public static final String DISEASE_OUTCOME_NOT_CURED = "未愈";
    public static final String DISEASE_OUTCOME_DECEASED = "死亡";

    // RegistrationClassification 枚举常量
    public static final String REGISTRATION_CLASSIFICATION_NEW_PATIENT = "新患者";
    public static final String REGISTRATION_CLASSIFICATION_RELAPSE = "复发";
    public static final String REGISTRATION_CLASSIFICATION_RETURN = "返回";
    public static final String REGISTRATION_CLASSIFICATION_TREATMENT_FAILURE = "治疗失败";
    public static final String REGISTRATION_CLASSIFICATION_OTHER = "其他";
}
