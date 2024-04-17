package com.project.featurekotlin.model

import androidx.lifecycle.MutableLiveData

class Count {
    val num: MutableLiveData<Int> = MutableLiveData(0)
// val ? num 변수 자체에 다른 MutableLiveData 인스턴스를 할당할 수는 없지만, num이 가리키는 MutableLiveData 객체의 내부 상태, 즉 여기서는 저장된 정수 값,은 변경될 수 있습니다.
}