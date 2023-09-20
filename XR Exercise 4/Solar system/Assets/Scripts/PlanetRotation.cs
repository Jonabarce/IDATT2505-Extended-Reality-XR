using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PlanetRotation : MonoBehaviour {

	public float rotationSpeed;
	public float dampAmt;



	
	void Update () {
	
	transform.Rotate((Vector3.up * rotationSpeed) * (Time.deltaTime * dampAmt), Space.Self);

    }

}

