package bean;

public class UserLoginRep {

    /**
     *  使用Gson自动生成的响应体类
     */

    private DataBean data;
    private int error_code;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        private int isRegister;
        private String token;
        private UserBean user;

        public int getIsRegister() {
            return isRegister;
        }

        public void setIsRegister(int isRegister) {
            this.isRegister = isRegister;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            private String accountId;
            private int accountType;
            private String address;
            private String appCode;
            private long createTime;
            private String dingdingUid;
            private String email;
            private int gender;
            private long joinUnitTime;
            private String nickName;
            private String phone;
            private String photoUrl;
            private String realName;
            private int riskLevel;
            private String uid;
            private String unitId;
            private String username;
            private long version;
            private String wechatUid;

            public String getAccountId() {
                return accountId;
            }

            public void setAccountId(String accountId) {
                this.accountId = accountId;
            }

            public int getAccountType() {
                return accountType;
            }

            public void setAccountType(int accountType) {
                this.accountType = accountType;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getAppCode() {
                return appCode;
            }

            public void setAppCode(String appCode) {
                this.appCode = appCode;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getDingdingUid() {
                return dingdingUid;
            }

            public void setDingdingUid(String dingdingUid) {
                this.dingdingUid = dingdingUid;
            }

            public String getEmail() {
                return email;
            }

            public void setEmail(String email) {
                this.email = email;
            }

            public int getGender() {
                return gender;
            }

            public void setGender(int gender) {
                this.gender = gender;
            }

            public long getJoinUnitTime() {
                return joinUnitTime;
            }

            public void setJoinUnitTime(long joinUnitTime) {
                this.joinUnitTime = joinUnitTime;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPhotoUrl() {
                return photoUrl;
            }

            public void setPhotoUrl(String photoUrl) {
                this.photoUrl = photoUrl;
            }

            public String getRealName() {
                return realName;
            }

            public void setRealName(String realName) {
                this.realName = realName;
            }

            public int getRiskLevel() {
                return riskLevel;
            }

            public void setRiskLevel(int riskLevel) {
                this.riskLevel = riskLevel;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUnitId() {
                return unitId;
            }

            public void setUnitId(String unitId) {
                this.unitId = unitId;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public long getVersion() {
                return version;
            }

            public void setVersion(long version) {
                this.version = version;
            }

            public String getWechatUid() {
                return wechatUid;
            }

            public void setWechatUid(String wechatUid) {
                this.wechatUid = wechatUid;
            }
        }
    }
}
