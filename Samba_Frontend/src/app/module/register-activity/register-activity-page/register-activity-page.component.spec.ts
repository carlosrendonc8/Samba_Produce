import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterActivityPageComponent } from './register-activity-page.component';

describe('RegisterActivityPageComponent', () => {
  let component: RegisterActivityPageComponent;
  let fixture: ComponentFixture<RegisterActivityPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterActivityPageComponent]
    });
    fixture = TestBed.createComponent(RegisterActivityPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
