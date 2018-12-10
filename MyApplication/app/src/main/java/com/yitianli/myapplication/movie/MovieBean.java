package com.yitianli.myapplication.movie;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieBean {


    /**
     * count : 2
     * start : 0
     * total : 27
     * subjects : [{"rating":{"max":10,"average":8.1,"details":{"1":145,"2":725,"3":5837,"4":12890,"5":8943},"stars":"40","min":0},"genres":["动作","奇幻","冒险"],"title":"海王","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg"},"name_en":"Jason Momoa","name":"杰森·莫玛","alt":"https://movie.douban.com/celebrity/1022614/","id":"1022614"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34697.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34697.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34697.jpg"},"name_en":"Amber Heard","name":"艾梅柏·希尔德","alt":"https://movie.douban.com/celebrity/1044702/","id":"1044702"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9206.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9206.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9206.jpg"},"name_en":"Willem Dafoe","name":"威廉·达福","alt":"https://movie.douban.com/celebrity/1010539/","id":"1010539"}],"durations":["143分钟"],"collect_count":180846,"mainland_pubdate":"2018-12-07","has_video":false,"original_title":"Aquaman","subtype":"movie","directors":[{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.jpg"},"name_en":"James Wan","name":"温子仁","alt":"https://movie.douban.com/celebrity/1032122/","id":"1032122"}],"pubdates":["2018-12-07(中国大陆)","2018-12-21(美国)"],"year":"2018","images":{"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg"},"alt":"https://movie.douban.com/subject/3878007/","id":"3878007"},{"rating":{"max":10,"average":8.2,"details":{"1":166,"2":931,"3":7877,"4":21438,"5":14361},"stars":"40","min":0},"genres":["剧情","喜剧"],"title":"无名之辈","casts":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1415455964.31.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1415455964.31.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1415455964.31.jpg"},"name_en":"Jianbin Chen","name":"陈建斌","alt":"https://movie.douban.com/celebrity/1274626/","id":"1274626"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478066140.77.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478066140.77.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1478066140.77.jpg"},"name_en":"Suxi Ren","name":"任素汐","alt":"https://movie.douban.com/celebrity/1362973/","id":"1362973"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1541855083.14.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1541855083.14.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1541855083.14.jpg"},"name_en":"Bin-long Pan","name":"潘斌龙","alt":"https://movie.douban.com/celebrity/1316365/","id":"1316365"}],"durations":["108分钟"],"collect_count":376083,"mainland_pubdate":"2018-11-16","has_video":false,"original_title":"无名之辈","subtype":"movie","directors":[{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1541992522.36.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1541992522.36.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1541992522.36.jpg"},"name_en":"Xiaozhi Rao","name":"饶晓志","alt":"https://movie.douban.com/celebrity/1326752/","id":"1326752"}],"pubdates":["2018-11-16(中国大陆)"],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2539661066.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2539661066.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2539661066.jpg"},"alt":"https://movie.douban.com/subject/27110296/","id":"27110296"}]
     * title : 正在上映的电影-上海
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":8.1,"details":{"1":145,"2":725,"3":5837,"4":12890,"5":8943},"stars":"40","min":0}
         * genres : ["动作","奇幻","冒险"]
         * title : 海王
         * casts : [{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg"},"name_en":"Jason Momoa","name":"杰森·莫玛","alt":"https://movie.douban.com/celebrity/1022614/","id":"1022614"},{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34697.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34697.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p34697.jpg"},"name_en":"Amber Heard","name":"艾梅柏·希尔德","alt":"https://movie.douban.com/celebrity/1044702/","id":"1044702"},{"avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9206.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9206.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p9206.jpg"},"name_en":"Willem Dafoe","name":"威廉·达福","alt":"https://movie.douban.com/celebrity/1010539/","id":"1010539"}]
         * durations : ["143分钟"]
         * collect_count : 180846
         * mainland_pubdate : 2018-12-07
         * has_video : false
         * original_title : Aquaman
         * subtype : movie
         * directors : [{"avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1509950363.8.jpg"},"name_en":"James Wan","name":"温子仁","alt":"https://movie.douban.com/celebrity/1032122/","id":"1032122"}]
         * pubdates : ["2018-12-07(中国大陆)","2018-12-21(美国)"]
         * year : 2018
         * images : {"small":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg","large":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg","medium":"https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg"}
         * alt : https://movie.douban.com/subject/3878007/
         * id : 3878007
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String mainland_pubdate;
        private boolean has_video;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<String> durations;
        private List<CastsBean> directors;
        private List<String> pubdates;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getMainland_pubdate() {
            return mainland_pubdate;
        }

        public void setMainland_pubdate(String mainland_pubdate) {
            this.mainland_pubdate = mainland_pubdate;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<String> getDurations() {
            return durations;
        }

        public void setDurations(List<String> durations) {
            this.durations = durations;
        }

        public List<CastsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<CastsBean> directors) {
            this.directors = directors;
        }

        public List<String> getPubdates() {
            return pubdates;
        }

        public void setPubdates(List<String> pubdates) {
            this.pubdates = pubdates;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 8.1
             * details : {"1":145,"2":725,"3":5837,"4":12890,"5":8943}
             * stars : 40
             * min : 0
             */

            private int max;
            private double average;
            private DetailsBean details;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public DetailsBean getDetails() {
                return details;
            }

            public void setDetails(DetailsBean details) {
                this.details = details;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }

            public static class DetailsBean {
                /**
                 * 1 : 145
                 * 2 : 725
                 * 3 : 5837
                 * 4 : 12890
                 * 5 : 8943
                 */

                @SerializedName("1")
                private int _$1;
                @SerializedName("2")
                private int _$2;
                @SerializedName("3")
                private int _$3;
                @SerializedName("4")
                private int _$4;
                @SerializedName("5")
                private int _$5;

                public int get_$1() {
                    return _$1;
                }

                public void set_$1(int _$1) {
                    this._$1 = _$1;
                }

                public int get_$2() {
                    return _$2;
                }

                public void set_$2(int _$2) {
                    this._$2 = _$2;
                }

                public int get_$3() {
                    return _$3;
                }

                public void set_$3(int _$3) {
                    this._$3 = _$3;
                }

                public int get_$4() {
                    return _$4;
                }

                public void set_$4(int _$4) {
                    this._$4 = _$4;
                }

                public int get_$5() {
                    return _$5;
                }

                public void set_$5(int _$5) {
                    this._$5 = _$5;
                }
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg
             * large : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg
             * medium : https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2541280047.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg"}
             * name_en : Jason Momoa
             * name : 杰森·莫玛
             * alt : https://movie.douban.com/celebrity/1022614/
             * id : 1022614
             */

            private AvatarsBean avatars;
            private String name_en;
            private String name;
            private String alt;
            private String id;

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName_en() {
                return name_en;
            }

            public void setName_en(String name_en) {
                this.name_en = name_en;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p32853.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
